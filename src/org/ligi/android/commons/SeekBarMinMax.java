package org.ligi.android.commons;

import android.content.Context;
import android.widget.SeekBar;

/**
 * a widget extending SeekBar to have a minimum
 * 
 * @author ligi
 *
 */
public class SeekBarMinMax extends SeekBar {

	private int min=0;
	

	public SeekBarMinMax(Context context,int min,int max) {
		super(context);
		this.min=min;
		this.setMax(max-min);
	}
	
	@Override
	public  int getProgress() {
		return super.getProgress()+min;
	}

	public synchronized void setProgress2(int progress) {
		//Log.i("setprogress2"+(progress));
	}	
	@Override
	public synchronized void setProgress(int progress) {
		//Log.i("setprogress"+(progress-min));
		if ((progress>=min)&&(progress<=this.getMax()+min))
			setProgress2(progress-min);
		else
			setProgress2(0);
		super.setProgress(0);
	}
}
