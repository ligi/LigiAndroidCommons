package org.ligi.android.common.preferences;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.preference.DialogPreference;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
/**
 * a Preference with a SeekBar !Warning untested!
 *
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License: GPLv3
 */
public class SeekBarPreference extends DialogPreference implements OnSeekBarChangeListener{

    private Context context;
    private SeekBar seek_bar;
    private int max=Integer.MAX_VALUE;
    private EditText edit_text;
    
    public SeekBarPreference(Context context) {
        super(context,null);
        this.context = context;
    }
    public SeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    protected void onPrepareDialogBuilder(Builder builder) {

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new
        		LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
        				LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.setMinimumWidth(400);
        layout.setPadding(20, 20, 20, 20);

  
        edit_text=new EditText(context);
        edit_text.setInputType(InputType.TYPE_CLASS_NUMBER);
        edit_text.setText(""+getPersistedInt(0));
        layout.addView(edit_text);
       
        
        seek_bar = new SeekBar(context);
        seek_bar.setMax(max);
      
        seek_bar.setLayoutParams(new
        		ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
        				ViewGroup.LayoutParams.WRAP_CONTENT));
        seek_bar.setOnSeekBarChangeListener(this);
        seek_bar.setProgress(getPersistedInt(0)); 
        
        layout.addView(seek_bar);
        
        builder.setView(layout);
        super.onPrepareDialogBuilder(builder);
    }

    protected void onDialogClosed(boolean positiveResult) {
        if(positiveResult){
        	persistInt(seek_bar.getProgress());
        	this.getOnPreferenceChangeListener().onPreferenceChange(this, seek_bar.getProgress());
        }
        
    }
    public void setMax(int max) {
		this.max = max;
	}
	public int getMax() {
		return max;
	}
	
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		
		edit_text.setText(""+progress);
	}

	public void onStartTrackingTouch(SeekBar seekBar) {
	}

	public void onStopTrackingTouch(SeekBar seekBar) {
	}

} 