package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemNhanVienActivity extends AppCompatActivity {
    Button btnAdd;
    EditText addTen, addNamsinh, addQueQuan, addTrinhdo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhan_vien);

        btnAdd = findViewById(R.id.addNhanVien);
        addTen = findViewById(R.id.addTen);
        addNamsinh = findViewById(R.id.addNamsinh);
        addQueQuan = findViewById(R.id.addQuequan);
        addTrinhdo = findViewById(R.id.addTrinhdo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(getBaseContext());
                String nvName = addTen.getText().toString();
                String nvDob = addNamsinh.getText().toString();
                String nvQue = addQueQuan.getText().toString();
                String nvLevel = addTrinhdo.getText().toString();

                NhanVien nhanVien = new NhanVien(nvName, nvDob, nvQue, nvLevel);

                db.addNhanVien(nhanVien);

                Toast.makeText(getBaseContext(),"Thêm dữ liệu thành công",Toast.LENGTH_SHORT).show();
                Reset();
            }
        });
    }

    protected  void Reset(){
        addTen.setText("");
        addNamsinh.setText("");
        addQueQuan.setText("");
        addTrinhdo.setText("");
    }

}