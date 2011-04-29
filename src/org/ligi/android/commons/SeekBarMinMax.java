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
	public synchronized int getProgress() {
		return super.getProgress()+min;
	}

	@Override
	public synchronized void setProgress(int progress) {
		super.setProgress(progress-min);
	}
}
