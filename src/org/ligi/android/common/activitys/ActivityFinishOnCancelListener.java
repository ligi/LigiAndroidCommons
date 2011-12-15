package org.ligi.android.common.activitys;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class ActivityFinishOnCancelListener implements OnCancelListener {

	Activity activity2finish;
	
	public ActivityFinishOnCancelListener(
			Activity activity2close) {
		this.activity2finish=activity2close;
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		activity2finish.finish();
	}

}
