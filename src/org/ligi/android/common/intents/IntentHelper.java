/*                                                                                                                          
 * This software is free software; you can redistribute it and/or modify                                                     
 * it under the terms of the GNU General Public License as published by                                                     
 * the Free Software Foundation; either version 3 of the License, or                                                        
 * (at your option) any later version.                                                                                      
 *                                                                                                                          
 * This program is distributed in the hope that it will be useful, but                                                      
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY                                               
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License                                                  
 * for more details.                                                                                                        
 *                                                                                                                          
 * You should have received a copy of the GNU General Public License along                                                  
 * with this program; if not, write to the Free Software Foundation, Inc.,                                                  
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA                                                                    
 */
package org.ligi.android.common.intents;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.net.Uri;

/**
 * some static functions to help with intents/actions
 * 
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License GPLv3
 */

public class IntentHelper {

	/**
	 * checks if an action is avail and start it if it is or option to goto market to install
	 * 
	 * @param ctx - the Context
	 * @param action - the Action
	 * @return if started
	 */
	public static boolean action(Context ctx,String action) {
		if (!isIntentAvailable(ctx.getPackageManager(),new Intent(action))) {
			open_market_for_missing_action(ctx,action);
			return false;
		}
		
		try {
			ctx.startActivity(new Intent(action)); }
		catch (Exception e) { return false; }
		
		return true;
	}
	
	
	public static void open_market_for_missing_action(final Context ctx,final String action) {
		new AlertDialog.Builder(ctx).setTitle("App not found")
		 .setMessage("I am missing an APP to do that - please install!")
		 .setPositiveButton("OK", new OnClickListener() {

			public void onClick(DialogInterface arg0, int arg1) {
				ctx.startActivity(new Intent().setAction(Intent.ACTION_VIEW)
		        .setData(Uri.parse("market://search?q=" + action)));
			}
			 
		 })
		 .show();
	}
	
	/**
	 * @see action + 
	 * 
	 * @param ctx
	 * @param action
	 */
	public static boolean action4result(Activity ctx,String action,int requestCode) {
		if (!isIntentAvailable(ctx.getPackageManager(),new Intent(action))) {
			open_market_for_missing_action(ctx,action);
			return false;
		}
		
		try {
			ctx.startActivityForResult(new Intent(action), requestCode); }
		catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public static boolean isIntentAvailable(PackageManager pm,Intent i) {
		return pm.queryIntentActivities(i,PackageManager.MATCH_DEFAULT_ONLY).size() >0;
	}
	
	public static void startActivityClass(Context ctx,Class activity_class) {
		ctx.startActivity(new Intent(ctx,activity_class));
	}
}
