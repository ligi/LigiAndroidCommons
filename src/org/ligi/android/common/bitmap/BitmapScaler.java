package org.ligi.android.common.bitmap;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;

/**
 * class to scale bitmaps relative to other stuff
 *  
 * usage:
 *  you construct this class with a CheckBoxPreference and then add the Preferences  
 *  where you want to toggle enable/disable depending on the CheckBox 
 *  via addPreference2SetEnable(Preference p)
 * 
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License: GPLv3
 */

public class BitmapScaler {

	public static  Bitmap relative2View(View view,Bitmap orig, float x_scale_, float y_scale_) {
		// create a matrix for the manipulation
		Matrix matrix = new Matrix();
		
		float x_scale, y_scale;
		if (y_scale_ != 0f)
			// take the given y scale
			y_scale = (view.getHeight() * y_scale_) / orig.getHeight();
		else
			// take x_scale
			y_scale = (view.getWidth() * x_scale_) / orig.getWidth();

		if (x_scale_ != 0f)
			// take the given x scale
			x_scale = (view.getWidth() * x_scale_) / orig.getWidth();
		else
			// take the given y scale
			x_scale = (view.getHeight() * y_scale_) / orig.getHeight();

		matrix.postScale(x_scale, y_scale);
		
		return Bitmap.createBitmap(orig, 0, 0, orig.getWidth(),orig.getHeight(), matrix, true);
	}

}
