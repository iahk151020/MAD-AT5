package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ThemSinhViennActivity extends AppCompatActivity {

    Button btnAdd;
    TextInputEditText tieTenSinhVien, tieMaSinhVien, tieQueQuan, tieNamHoc, tieNamSinh;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vienn);

        dbHelper = new DBHelper(this);

        btnAdd = findViewById(R.id.btn_submit_them_sinh_vien);
        tieTenSinhVien = findViewById(R.id.tie_ten);
        tieMaSinhVien = findViewById(R.id.tie_ma_sinh_vien);
        tieQueQuan = findViewById(R.id.tie_que_quan);
        tieNamHoc = findViewById(R.id.tie_nam_hoc);
        tieNamSinh = findViewById(R.id.tie_nam_sinh);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenSinhVien = tieTenSinhVien.getText().toString();
                String queQuan = tieQueQuan.getText().toString();
                int maSinhVien = Integer.parseInt(tieMaSinhVien.getText().toString());
                int namHoc = Integer.parseInt(tieNamHoc.getText().toString());
                int namSinh = Integer.parseInt(tieNamSinh.getText().toString());

                dbHelper.insertSinhVien(new SinhVien(maSinhVien, namSinh, namHoc, tenSinhVien, queQuan));

            }
        });

    }
}