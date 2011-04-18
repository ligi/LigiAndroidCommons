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
