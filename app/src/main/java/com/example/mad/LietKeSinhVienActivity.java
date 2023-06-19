package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class LietKeSinhVienActivity extends AppCompatActivity {

    ArrayList<SinhVien> svList;
    LVSinhVienAdapter adapter;
    ListView lvSinhVien;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liet_ke_sinh_vien);

        dbHelper = new DBHelper(this);
        svList = (ArrayList<SinhVien>) dbHelper.getSinhVienList();

         adapter = new LVSinhVienAdapter(svList);
         lvSinhVien = findViewById(R.id.lv_danh_sach_sinh_vien);
         lvSinhVien.setAdapter(adapter);
    }
}