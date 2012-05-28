package org.ligi.android.common.activitys;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

/**
 * 
 * from http://stackoverflow.com/a/8765901/322642
 * and slightly modified
 *  
 */
public class ActivityOrientationLocker {
	
	public static void disableRotation(Activity activity)	{ 
		
		switch (activity.getResources().getConfiguration().orientation){
        case Configuration.ORIENTATION_PORTRAIT:
            if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.FROYO){
            	activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else {
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                if(rotation == android.view.Surface.ROTATION_90|| rotation == android.view.Surface.ROTATION_180){
            		activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                } else {
                	activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
            }   
            break;

        case Configuration.ORIENTATION_LANDSCAPE:
            if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.FROYO){
            	activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                if(rotation == android.view.Surface.ROTATION_0 || rotation == android.view.Surface.ROTATION_90){
                	activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else {
                	activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                }
            }
            break;
		}//switch
	
	}

	public static void enableRotation(Activity activity) {
		  activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

	}
}
