package com.example.finaltest;

public class NhanVien {

    private int id;
    private String hoTen, namSinh, queQuan, trinhDo;

    public NhanVien(int id, String hoTen, String namSinh, String queQuan, String trinhDo) {
        this.id = id;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.trinhDo = trinhDo;
    }

    public NhanVien(String hoTen, String namSinh, String queQuan, String trinhDo) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.trinhDo = trinhDo;
    }

    public NhanVien() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    @Override
    public String toString() {
        return  "Họ và tên:" +getHoTen() + " \n" +
                "Năm sinh: "+getNamSinh() +"\n" +
                "Quê quán: "+getQueQuan() +"\n" +
                "Trình độ: "+getTrinhDo();
    }
}
