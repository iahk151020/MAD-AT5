package com.example.mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper2 extends SQLiteOpenHelper {

    final static String DB_NAME = "mydb.db";
    final static int DB_VERSION = 1;
    String TABLE_STUDENT = "student";
    String TABLE_CLASS = "class";

    public DBHelper2(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createStudentTable = "create table" + TABLE_STUDENT + "(" +
                "id int primary key," +
                "name varchar(255)," +
                "city varchar(255)," +
                "birthYear int," +
                "studyYear int" +
                ")";

        String createTableClass = "create table " + TABLE_CLASS + "(" +
                "id int primary key," +
                "className varchar(255)," +
                "des varchar(255)" +
                ")";

        sqLiteDatabase.execSQL(createTableClass);
        sqLiteDatabase.execSQL(createTableClass);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_STUDENT);
        onCreate(sqLiteDatabase);
    }

    List<SinhVien> getStudentList() {
        List<SinhVien> studentList = new ArrayList<>();
        String sql = "select * from " + TABLE_STUDENT;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String city = cursor.getString(2);
            int birthYear = cursor.getInt(3);
            int studyYear = cursor.getInt(4);

            studentList.add(new SinhVien(id, birthYear, studyYear, name, city));
            cursor.moveToNext();

        }
        return studentList;
    }

    void insertStudent(SinhVien sv) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id", sv.getMaSinhVien());
        values.put("name", sv.getTen());
        values.put("city", sv.getQueQuan());
        values.put("birthYear", sv.getNamSinh());
        values.put("studyYear", sv.getNamHoc());

        db.insert(TABLE_STUDENT, null, values);
    }

    int genStudentId() {
        return getStudentList().size() + 1;
    }
}
