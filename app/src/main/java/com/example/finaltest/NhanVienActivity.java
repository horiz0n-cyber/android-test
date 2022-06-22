package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NhanVienActivity extends AppCompatActivity {

    Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);

        btnThem = findViewById(R.id.themnhanvien);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddActivity();
            }
        });

        loadListNhanVien();
    }

    protected void loadListNhanVien(){
        DatabaseHelper db = new DatabaseHelper(getBaseContext());
        final List<NhanVien> listNhanVien= db.getAllNhanVien();

        ListView listView =(ListView)findViewById(R.id.dsnhanvien);
        ArrayAdapter<NhanVien> adapter=
                new ArrayAdapter<NhanVien>(this,android.R.layout.simple_list_item_1,listNhanVien);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    protected void openAddActivity(){
        Intent intent = new Intent(NhanVienActivity.this, ThemNhanVienActivity.class);
        startActivity(intent);
    }
}