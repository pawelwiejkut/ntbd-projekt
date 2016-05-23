package generatedata.DataFactory.impl;

import generatedata.DataFactory.PlaceDataValues;

/**
 * Created by pawelwiejkut on 21.05.2016.
 */
public class DefaultPlaceData implements PlaceDataValues {

    private static String[] name ={"regał A","regał B", "regał C","regał D", "regał E", "regał F"};

    public String[] getPlaceName() {
        return name;
    }
}
