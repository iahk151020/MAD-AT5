package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ThemLopActivity extends AppCompatActivity {

    Button btnAdd;
    TextInputEditText tieMaLop, tieTenLop, tieMoTa;
    FileHelper fileHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lop);

        fileHelper = new FileHelper("classes.txt", this);

        btnAdd = findViewById(R.id.btn_submit_them_lop);
        tieMaLop = findViewById(R.id.tie_ma_lop);
        tieTenLop = findViewById(R.id.tie_ten_lop);
        tieMoTa = findViewById(R.id.tie_mo_ta);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maLop = Integer.parseInt(tieMaLop.getText().toString());
                String tenLop = tieTenLop.getText().toString();
                String moTa = tieMoTa.getText().toString();

                fileHelper.insertToFile(new Lop(maLop, tenLop, moTa));
            }
        });
    }
}