package org.ligi.android.common.activitys;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.view.Surface;


/**
 * 
 * from http://stackoverflow.com/a/8765901/322642
 * and slightly modified
 *  
 */
public class ActivityOrientationLocker {
	
	public static void disableRotation(Activity activity)	{       
	    final int orientation = activity.getResources().getConfiguration().orientation;
	    final int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();

	    // fallback values
	    int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
	    int SCREEN_ORIENTATION_REVERSE_PORTRAIT = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

	    // after froyo we have real reverse orientations - so use them 
	    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.FROYO) {
	        SCREEN_ORIENTATION_REVERSE_LANDSCAPE = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
	        SCREEN_ORIENTATION_REVERSE_PORTRAIT = ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
	    } 

	    if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_90)
	    {
	        if (orientation == Configuration.ORIENTATION_PORTRAIT)
	        {
	            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	        }
	        else if (orientation == Configuration.ORIENTATION_LANDSCAPE)
	        {
	            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	        }
	    }
	    else if (rotation == Surface.ROTATION_180 || rotation == Surface.ROTATION_270) 
	    {
	        if (orientation == Configuration.ORIENTATION_PORTRAIT) 
	        {
	            activity.setRequestedOrientation(SCREEN_ORIENTATION_REVERSE_PORTRAIT);
	        }
	        else if (orientation == Configuration.ORIENTATION_LANDSCAPE) 
	        {
	            activity.setRequestedOrientation(SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
	        }
	    }
	}

	public static void enableRotation(Activity activity) {
		  activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

	}
}
