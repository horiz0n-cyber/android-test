package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViTriActivity extends AppCompatActivity {

    Button btnThemvitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi_tri);

        btnThemvitri = findViewById(R.id.themvitri);
        btnThemvitri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViTriActivity.this, ThemViTriActivity.class);
                startActivity(intent);
            }
        });
        loadListVitri();
    }

    protected void loadListVitri(){
        DatabaseHelper db = new DatabaseHelper(getBaseContext());

        ListView listView;
        listView = (ListView) findViewById(R.id.dsvitri);

        final List<ViTri> listViTri = db.getALLViTri();

        ArrayAdapter<ViTri> adapter =
                new ArrayAdapter<ViTri>(this, android.R.layout.simple_list_item_1, listViTri);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }
}