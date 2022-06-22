package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button nhanVien, viTri, nhanVienViTri,nhanVienNam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nhanVien = (Button) findViewById(R.id.nhanvien);
        viTri = (Button) findViewById(R.id.vitri);
        nhanVienViTri = (Button) findViewById(R.id.nhanvienvitri);
        nhanVienNam = (Button) findViewById(R.id.nhanvienNam);

        nhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, NhanVienActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        viTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(MainActivity.this, ViTriActivity.class);
                MainActivity.this.startActivity(myIntent2);
            }
        });

        nhanVienNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent3 = new Intent(MainActivity.this, NhanVienNamActivity.class);
                MainActivity.this.startActivity(myIntent3);
            }
        });
    }
}