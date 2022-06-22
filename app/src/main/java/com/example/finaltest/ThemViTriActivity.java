package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemViTriActivity extends AppCompatActivity {

    Button btnAddvitri;
    EditText addTenVitri, addMotavitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vi_tri);

        addTenVitri = findViewById(R.id.addTenvitri);
        addMotavitri = findViewById(R.id.addMotavitri);
        btnAddvitri = findViewById(R.id.addVitri);

        btnAddvitri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String vtTen = addTenVitri.getText().toString();
                    String vtMota = addMotavitri.getText().toString();

                    ViTri viTri = new ViTri(vtTen, vtMota);

                    DatabaseHelper db = new DatabaseHelper(getBaseContext());

                    db.addViTri(viTri);
                    Toast.makeText(getBaseContext(),"Thêm dữ liệu thành công",Toast.LENGTH_SHORT).show();
                    Reset();
            }
        });
    }

    protected void Reset(){
        addTenVitri.setText("");
        addMotavitri.setText("");
    }
}