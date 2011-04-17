package org.ligi.android.common.adapter;

import android.app.Activity;
import android.app.ListActivity;
import android.widget.BaseAdapter;
/**
 * Periodically invalidates an Adapter via notifyDataSetChanged
 * 
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License: GPLv3
 */
public class PeriodicallyInvalidateAdapter implements Runnable {
	
	private Activity ctx;
	private Invalidator myInvalidator;
	
	public PeriodicallyInvalidateAdapter(ListActivity ctx,BaseAdapter adapter) {
		this.ctx=ctx;
		myInvalidator=new Invalidator(adapter);
		new Thread(this).start();
	}
	
	class Invalidator implements Runnable{
		private BaseAdapter adapter;
		public Invalidator(BaseAdapter adapter) {
			this.adapter=adapter;
		}
		public void run() {
			adapter.notifyDataSetChanged();
		}
	}
	
	private boolean running=true;
	
	public void run() {
		while (running) 
			try {
		  		ctx.runOnUiThread(myInvalidator);	
		  		Thread.sleep(200);
		  	}
			catch (Exception e) {}
	}
				
}
 