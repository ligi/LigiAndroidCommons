package org.ligi.android.common.dialogs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
/**
 * a class implementing DialogInterface.OnClickListener to dismiss the dialog 
 * typical Cancel / OK use case and faster to type this way
 * 
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License: GPLv3
 */
public class DialogDiscarder implements OnClickListener {

	public void onClick(DialogInterface dialog, int which) {
		dialog.dismiss();
	}

}
