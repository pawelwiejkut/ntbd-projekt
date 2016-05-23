package generatedata.DataFactory.impl;

import generatedata.DataFactory.ItemDataValues;

/**
 * Created by pawelwiejkut on 21.05.2016.
 */
public class DefaultItemValues implements ItemDataValues {

    private String[] itemName={"śróba","podkładka","dolot","sprzęgło","korbowód","chłodnica","zapłon","miska olejowa","blok silnika","aparat zapłonowy","kolektor ssący","zawór przelewowy"};

    @Override
    public String[] getItemName() {
        return itemName;
    }
}
