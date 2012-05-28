package org.ligi.android.common.arrays;

import java.util.Arrays;

public class ArrayHelper {
	
	/**
	 * from http://stackoverflow.com/a/784842/322642
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> T[] concat(T[] first, T[] second) {
		  T[] result = Arrays.copyOf(first, first.length + second.length);
		  System.arraycopy(second, 0, result, first.length, second.length);
		  return result;
		}
}
