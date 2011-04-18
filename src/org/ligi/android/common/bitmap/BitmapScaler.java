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
package org.ligi.android.common.bitmap;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;

/**
 * class to scale bitmaps relative to other stuff
 *  
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License: GPLv3
 */

public class BitmapScaler {

	public static Bitmap relative2View(View view,Bitmap orig, float x_scale_, float y_scale_) {
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
