package com.example.finaltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "QLVTCV";

    private static final String TABLE_NV = "nhanvien";
    private static final String NV_ID = "id";
    private static final String NV_NAME = "hoten";
    private static final String NV_DOB = "ngaysinh";
    private static final String NV_QUE = "quequan";
    private static final String NV_LEVEL = "trinhdo";
    
    private  static final String TABLE_VT = "vitri";
    private  static final String VT_ID = "id";
    private  static final String VT_NAME = "tenvitri";
    private  static final String VT_DES = "motavitri";
    
    private static final String TABLE_NVVT = "nhanvien_vitri";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("DB Manager", "DB Manager");
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery1 = "CREATE TABLE "+ TABLE_NV+" (" +
                NV_ID +" integer primary key autoincrement , " +
                NV_NAME + " TEXT, " +
                NV_DOB + " TEXT, " +
                NV_QUE + " TEXT, " +
                NV_LEVEL +" TEXT)";
        String sqlQuery2 = "CREATE TABLE "+TABLE_VT+" ("+
                VT_ID + " integer primary key autoincrement , "+
                VT_NAME + " TEXT, "+
                VT_DES +" TEXT)";
        db.execSQL(sqlQuery1);
        db.execSQL(sqlQuery2);
        Log.d("Check database", "sql2");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_VT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_VT);
        onCreate(db);
        Toast.makeText(context, "Drop successfully", Toast.LENGTH_SHORT).show();

    }

    public void addNhanVien(NhanVien nhanVien){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put(NV_NAME, nhanVien.getHoTen());
        values.put(NV_DOB, nhanVien.getNamSinh());
        values.put(NV_QUE, nhanVien.getQueQuan());
        values.put(NV_LEVEL, nhanVien.getTrinhDo());

        //Neu de null thi khi value bang null thi loi
        db.insert(TABLE_NV,null,values);
        db.close();

    }

    public List<NhanVien> getAllNhanVien(){
        List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
        //Select all query
        String selectQuery = "SELECT * FROM "+ TABLE_NV;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(cursor.getInt(0));
                nhanVien.setHoTen(cursor.getString(1));
                nhanVien.setNamSinh(cursor.getString(2));
                nhanVien.setQueQuan(cursor.getString(3));
                nhanVien.setTrinhDo(cursor.getString(4));
                listNhanVien.add(nhanVien);
//                Log.d("fix", String.valueOf(listNhanVien));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return listNhanVien;
    }

    protected List<NhanVien> getNhanVienByName(){
        List<NhanVien> listNhanVien = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+TABLE_NV+" WHERE "+NV_NAME+" LIKE '%Nam%' AND "
                +NV_DOB+"='1995'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(cursor.getInt(0));
                nhanVien.setHoTen(cursor.getString(1));
                nhanVien.setNamSinh(cursor.getString(2));
                nhanVien.setQueQuan(cursor.getString(3));
                nhanVien.setTrinhDo(cursor.getString(4));
                listNhanVien.add(nhanVien);
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listNhanVien;
    }

    protected void addViTri(ViTri viTri){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VT_NAME, viTri.getTenViTri());
        values.put(VT_DES, viTri.getMoTaViTri());

        db.insert(TABLE_VT,null,values);
        db.close();
    }

    protected List<ViTri> getALLViTri(){
        List<ViTri> listViTri = new ArrayList<>();
        //select all query;
        String selectQuery = "SELECT * FROM "+TABLE_VT;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                ViTri viTri = new ViTri();
                viTri.setId(cursor.getInt(0));
                viTri.setTenViTri(cursor.getString(1));
                viTri.setMoTaViTri(cursor.getString(2));
                listViTri.add(viTri);
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listViTri ;
    }
}
