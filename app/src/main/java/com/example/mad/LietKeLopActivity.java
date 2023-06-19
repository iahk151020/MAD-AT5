package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LietKeLopActivity extends AppCompatActivity {

    LVLopAdapter adapter;
    ListView lvLop;
    ArrayList<Lop> lopList;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liet_ke_lop);

        dbHelper = new DBHelper(this);
        lopList = (ArrayList<Lop>) dbHelper.getLopList();
        adapter = new LVLopAdapter(lopList);
        lvLop = findViewById(R.id.lv_danh_sach_lop);
        lvLop.setAdapter(adapter);
    }
}