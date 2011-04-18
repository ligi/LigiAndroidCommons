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

package org.ligi.android.common.text;

import android.graphics.Paint;

/**
 * class to provide functions around Text
 *  
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 *
 * License: GPLv3
 */

public class TextHelper {

	/**
	 * calculate the width of a text for a paint
	 * 
	 * @param text
	 * @param paint
	 * @return the width
	 */
	public static float getTextWidth(String text,Paint paint) {
		float[] widths = new float[text.length()];
		paint.getTextWidths(text, widths);
		float res = 0;
		for (int i = 0; i < widths.length; i++)
			res += widths[i];
		return res;
	}

}
