package org.ligi.android.common.maps;
import com.google.android.maps.MapView;


public class MapCalculationsHelper {

	 /**
	  * @param map
	  * @param meters
	  * @param latitude
	  * @return
	  * 
	  * source: http://stackoverflow.com/a/6949877/322642
	  */
	 public static int metersToPixels(MapView map,float meters, double latitude) {
	        return (int) (map.getProjection().metersToEquatorPixels(meters) * (1/ Math.cos(Math.toRadians(latitude))));         
	 }
	    
}
