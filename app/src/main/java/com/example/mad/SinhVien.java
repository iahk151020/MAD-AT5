package com.example.mad;

public class SinhVien {
    private int maSinhVien, namSinh, namHoc;
    private String ten, queQuan;

    public SinhVien(int maSinhVien, int namSinh, int namHoc, String ten, String queQuan) {
        this.maSinhVien = maSinhVien;
        this.namSinh = namSinh;
        this.namHoc = namHoc;
        this.ten = ten;
        this.queQuan = queQuan;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
}
