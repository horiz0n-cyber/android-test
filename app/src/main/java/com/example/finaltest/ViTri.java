package com.example.finaltest;

public class ViTri {
    int id;
    private String tenViTri, moTaViTri;

    public ViTri() {
    }

    public ViTri(int id, String tenViTri, String moTaViTri) {
        this.id = id;
        this.tenViTri = tenViTri;
        this.moTaViTri = moTaViTri;
    }

    public ViTri(String tenViTri, String moTaViTri) {
        this.tenViTri = tenViTri;
        this.moTaViTri = moTaViTri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public String getMoTaViTri() {
        return moTaViTri;
    }

    public void setMoTaViTri(String moTaViTri) {
        this.moTaViTri = moTaViTri;
    }

    @Override
    public String toString() {
        return  "Tên vị trí: " + tenViTri + " \n" +
                "Mô tả vị trí: " + moTaViTri + " \n";
    }
}
