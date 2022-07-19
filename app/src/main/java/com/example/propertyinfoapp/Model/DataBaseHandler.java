package com.example.propertyinfoapp.Model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;

public class DataBaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PropertyInfoDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String PROPERTY_INFO_TABLE = "PropertyInfo";
    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private static final String PRICE_KEY = "price";
    private static final String AREA_KEY = "area";
    private static final String SEVENTWELEVEDOCUMENT_KEY = "seventwelvedocument";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDatabaseSQL = " create table " + PROPERTY_INFO_TABLE +
                "( " + ID_KEY + " integer  primary key  " +
                " ," + NAME_KEY + " text" + ", " + PRICE_KEY + " real" +
                ", " + AREA_KEY + " text " + ", " + SEVENTWELEVEDOCUMENT_KEY + " text" + " )";
        db.execSQL(createDatabaseSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exists " + PROPERTY_INFO_TABLE);
        onCreate(db);
    }
   public void createPropertyDeatils(Property property) {
       SQLiteDatabase database = getWritableDatabase();
       String addMartialSqlCommand = "insert into " + PROPERTY_INFO_TABLE +
               " values (null,' " + property.getName() +
               "', '" + property.getPrice() +
               "', '" + property.getArea() +
               "', '" + property.getSeventwelvedocument() +
               "')";
       database.execSQL(addMartialSqlCommand);
       database.close();
   }

    public void deletePropertyDetails(int id) {
        SQLiteDatabase database = getWritableDatabase();
        String deletepropertydetailscommand = "delete from " + PROPERTY_INFO_TABLE +
                " where " + ID_KEY + " = " + id;
        database.execSQL(deletepropertydetailscommand);
        database.close();
    }

    public void updatePropertyDetails(int propertyId, String name, double price, String area, String seventwelvedocument) {
        SQLiteDatabase database = this.getWritableDatabase();
        String updatepropertydetailscommand = " update " + PROPERTY_INFO_TABLE +
                " set " + NAME_KEY + " = '" + name + "' , " + PRICE_KEY + " = '" + price +
                "' , " + AREA_KEY + " = '" + area + "' " + "where " + ID_KEY + " = " + propertyId;
        database.execSQL(updatepropertydetailscommand);
        database.close();
    }

    public ArrayList<Property> returnAllPropertyDetailsObjects() {
        SQLiteDatabase database = getWritableDatabase();
        String sqlQueryCommmand = " select * from " + PROPERTY_INFO_TABLE;
        Cursor cursor = database.rawQuery(sqlQueryCommmand, null);
        ArrayList<Property> propertyArrayList = new ArrayList<>();
        while (cursor.moveToNext()) {
            Property currentPropertyArtObject = new Property
                    (Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getDouble(2), cursor.getString(3),cursor.getString(4));
            propertyArrayList.add(currentPropertyArtObject);

        }
        database.close();
        return propertyArrayList;
    }
    public Property returnAllPropertyDetailsObjects(int id) {
        SQLiteDatabase database  = getWritableDatabase();
        String sqlQueryCommand = " select * from "+PROPERTY_INFO_TABLE +
                " where " + ID_KEY+ " = " + id;
        Cursor cursor = database.rawQuery(sqlQueryCommand,null);
        Property propertyArtObject =  null;
        if(cursor.moveToFirst()){
            propertyArtObject = new Property(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getDouble(2), cursor.getString(3), cursor.getString(4));
        }
        database.close();
        return propertyArtObject;
    }
}
