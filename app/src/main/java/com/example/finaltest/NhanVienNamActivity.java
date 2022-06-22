package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NhanVienNamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien_nam);

        loadListNam();
    }

    protected void loadListNam(){
        ListView listView;
        listView = findViewById(R.id.dsNam);

        DatabaseHelper db = new DatabaseHelper(getBaseContext());
        final List<NhanVien> listNhanVien = db.getNhanVienByName();

        ArrayAdapter<NhanVien> adapter =
                new ArrayAdapter<NhanVien>(this, android.R.layout.simple_list_item_1, listNhanVien);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

    }
}