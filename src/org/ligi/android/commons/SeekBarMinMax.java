package org.ligi.android.commons;

import android.widget.SeekBar;

/**
 * a class wrapping SeekBar to have a minimum
 * 
 * @author ligi
 *
 */
public class SeekBarMinMax {
	private SeekBar mySeekBar;
	private int min=0;

	public SeekBarMinMax(SeekBar seek_bar,int min,int max) {
		mySeekBar=seek_bar;
		this.min=min;
		mySeekBar.setMax(max-min);
	}
	
	public synchronized int getProgress() {
		return mySeekBar.getProgress()+min;
	}

	public synchronized void setProgress(int progress) {
		mySeekBar.setProgress(progress-min);
	}
}
