package org.ligi.android.common.maps;

/*
import android.location.Location;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
*/

public class MapCalculationsHelper {

    /**
     * @param map
     * @param meters
     * @param latitude
     * @return
     *
     * source: http://stackoverflow.com/a/6949877/322642
    public static int metersToPixels(MapView map,float meters, double latitude) {
    return (int) (map.getProjection().metersToEquatorPixels(meters) * (1/ Math.cos(Math.toRadians(latitude))));
    }
     */

    /**
     * http://stackoverflow.com/a/3472793/322642
     *
     * @param p
     * @return public static Location geoPointToLocation(GeoPoint p) {
    Location res=new Location("calc");
    res.setLatitude(p.getLatitudeE6()/1000000F);
    res.setLongitude(p.getLongitudeE6()/1000000F);
    return res;
    }
     */

}
