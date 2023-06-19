package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnThemSinhVien, btnDSSinhVien, btnThemLop, btnDSLop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThemSinhVien = findViewById(R.id.btn_them_sinh_vien);
        btnDSSinhVien = findViewById(R.id.btn_danh_sach_sinh_vien);
        btnThemLop = findViewById(R.id.btn_them_lop);
        btnDSLop = findViewById(R.id.btn_danh_sach_lop);

        btnThemLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThemLopActivity.class);
                startActivity(intent);
            }
        });

        btnDSLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LietKeLopActivity.class);
                startActivity(intent);
            }
        });

        btnThemSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThemSinhViennActivity.class);
                startActivity(intent);
            }
        });

        btnDSSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LietKeSinhVienActivity.class);
                startActivity(intent);
            }
        });



    }
}