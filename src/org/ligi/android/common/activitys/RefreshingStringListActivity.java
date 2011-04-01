/**************************************************************************
 *                                          
 * Activity to show a changing strings in a list
 *                                          
 * Author:  Marcus -LiGi- Bueschleb   
 *
 * Project URL:
 *  http://mikrokopter.de/ucwiki/en/DUBwise
 * 
 * License:
 *  http://creativecommons.org/licenses/by-nc-sa/2.0/de/ 
 *  (Creative Commons / Non Commercial / Share Alike)
 *  Additionally to the Creative Commons terms it is not allowed
 *  to use this project in _any_ violent manner! 
 *  This explicitly includes that lethal Weapon owning "People" and 
 *  Organisations (e.g. Army & Police) 
 *  are not allowed to use this Project!
 *
 **************************************************************************/

package org.ligi.android.common.activitys;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * a ListActivity with a Thread to 
 * change the items in a some interval ( default 10Hz )
 * 
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License: GPLv3
 */
 public abstract class RefreshingStringListActivity extends ListActivity implements Runnable{

	private myArrayAdapter adapter;
	private boolean running=true;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		adapter=new myArrayAdapter(this);
	    this.setListAdapter(adapter);
	
	    new Thread(this).start();
	}


	public abstract String getStringByPosition(int pos);
	
	class myArrayAdapter extends BaseAdapter { 
		 
		private Activity context; 
		private int count=0;
		
        public myArrayAdapter(Activity context) {
        	super();
        	
            this.context=context;
            while (getStringByPosition(count++)!=null)
            	; // check how many items there are - the last one is null - indicates the end
        } 
 
        public View getView(int position, View convertView, ViewGroup parent) { 
        	LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=vi.inflate(android.R.layout.simple_list_item_1, null); 
            TextView label=(TextView)row.findViewById(android.R.id.text1);
            label.setText(getStringByPosition(position));
            return(row); 
        }

		public int getCount() {
			return count;
		}

		/**
		 * do not use - not implemented!
		 */
		public Object getItem(int arg0) {
			return null;
		}

		/**
		 * do not use - not implemented!
		 */
		public long getItemId(int position) {
			return 0;
		}

    }
	
	@Override
	protected void onDestroy() {
		running=false;
		super.onDestroy();
	}
	 
	final Handler mHandler = new Handler();
	// Create runnable for posting
	final Runnable mUpdateResults = new Runnable() {
		public void run() {
	    	   adapter.notifyDataSetChanged();
		}
	};

	public int getRefreshSleep() {
		return 100;
	}
	
	public void run() {
		while (running) {
			mHandler.post(mUpdateResults);
			try {
			Thread.sleep(getRefreshSleep());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

}
