package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LietKeLopActivity extends AppCompatActivity {

    LVLopAdapter adapter;
    ListView lvLop;
    List<Lop> lopList;
    FileHelper fileHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liet_ke_lop);

       fileHelper = new FileHelper("classes.txt", this);
        try {
            lopList = fileHelper.getAllClasses();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        adapter = new LVLopAdapter(lopList);
        lvLop = findViewById(R.id.lv_danh_sach_lop);
        lvLop.setAdapter(adapter);
    }
}