package com.example.mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mydb.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_SINHVIEN = "sinhVien";
    private static final String TABLE_LOP = "lop";
    private static final String TABLE_SINHVIEN_LOP = "sinhVien_lop";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateSinhVienTable = "CREATE TABLE " + TABLE_SINHVIEN + "(" +
                "maSinhVien INTEGER PRIMARY KEY," +
                "ten VARCHAR(255)," +
                "queQuan VARCHAR(255)," +
                "namHoc INTEGER," +
                "namSinh INTEGER" +
                ")";
        String queryCreateLopTable = "CREATE TABLE " + TABLE_LOP + "(" +
                "maLop INTEGER PRIMARY KEY," +
                "tenLop VARCHAR(255)," +
                "moTa VARCHAR(255)" +
                ")";
        String queryCreateTableSVLopTable = "CREATE TABLE " + TABLE_SINHVIEN_LOP + "(" +
                "id INTEGER PRIMARY KEY," +
                "maSinhVien INTEGER," +
                "maLop INTEGER" +
                ")";

        sqLiteDatabase.execSQL(queryCreateSinhVienTable);
        sqLiteDatabase.execSQL(queryCreateLopTable);
        sqLiteDatabase.execSQL(queryCreateTableSVLopTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SINHVIEN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SINHVIEN_LOP);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOP);

        onCreate(sqLiteDatabase);
    }

    public List<SinhVien> getSinhVienList() {
        List<SinhVien> listSinhVien = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM sinhVien", null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            int maSinhVien = cursor.getInt(0);
            String ten = cursor.getString(1);
            String queQuan = cursor.getString(2);
            int namHoc = cursor.getInt(3);
            int namSinh = cursor.getInt(4);

            listSinhVien.add(new SinhVien(maSinhVien, namHoc, namSinh, ten, queQuan));
            cursor.moveToNext();
        }

        return listSinhVien;
    }

    void insertSinhVien(SinhVien sinhVien){
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put("maSinhVien", sinhVien.getMaSinhVien());
        values.put("ten", sinhVien.getTen());
        values.put("queQuan", sinhVien.getQueQuan());
        values.put("namHoc", sinhVien.getNamHoc());
        values.put("namSinh", sinhVien.getNamSinh());

        db.insert(TABLE_SINHVIEN, null, values);

    }

    public List<Lop> getLopList() {
        List<Lop> listLop = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM lop", null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            int maLop = cursor.getInt(0);
            String tenLop = cursor.getString(1);
            String moTa = cursor.getString(2);

            listLop.add(new Lop(maLop, tenLop, moTa));
            cursor.moveToNext();
        }

        return listLop;
    }

    void insertLop(Lop lop){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("maLop", lop.getMaLop());
        values.put("tenLop", lop.getTenLop());
        values.put("moTa", lop.getMoTa());

        db.insert(TABLE_LOP, null, values);
    }

    int genMaSinhVien() {
        return getSinhVienList().size() + 1;
    }

}
