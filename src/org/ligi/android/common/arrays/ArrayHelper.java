package org.ligi.android.common.arrays;

public class ArrayHelper {

    /**
     * from http://stackoverflow.com/a/784842/322642
     *
     * @param first
     * @param second
     * @return
     */    /* - this code makes problems on old android phones as copyOf is not available
	public static <T> T[] concat(T[] first, T[] second) {
		  T[] result = Arrays.copyOf(first, first.length + second.length);
		  System.arraycopy(second, 0, result, first.length, second.length);
		  return result;
		}
    */
    public static <T> T[] concat(T[] a, T[] b) {
        final int alen = a.length;
        final int blen = b.length;
        @SuppressWarnings("unchecked")
        final T[] result = (T[]) java.lang.reflect.Array.
                newInstance(a.getClass().getComponentType(), alen + blen);
        System.arraycopy(a, 0, result, 0, alen);
        System.arraycopy(b, 0, result, alen, blen);
        return result;
    }
}
