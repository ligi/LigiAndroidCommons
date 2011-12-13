package org.ligi.android.common.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class ActivityFinishOnDialogClickListener implements OnClickListener {

	private Activity activity2finish;
	
	public ActivityFinishOnDialogClickListener(
			Activity activity2finish) {
		this.activity2finish=activity2finish;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		activity2finish.finish();
	}

}
