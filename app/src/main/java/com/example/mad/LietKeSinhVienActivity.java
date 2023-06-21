package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LietKeSinhVienActivity extends AppCompatActivity {

   List<SinhVien> svList;
    LVSinhVienAdapter adapter;


    DBHelper dbHelper;
    ListView lvSinhVien;
    FileHelper fileHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liet_ke_sinh_vien);
        Log.i("LKSV onCreate", "1");
        fileHelper = new FileHelper("students.txt", this);

        try {
            svList = fileHelper.getAllStudents();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        adapter = new LVSinhVienAdapter(svList);
         lvSinhVien = findViewById(R.id.lv_danh_sach_sinh_vien);
         lvSinhVien.setAdapter(adapter);
    }
}