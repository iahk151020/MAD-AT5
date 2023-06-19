package com.example.mad;

public class SinhVien_Lop {
    private int maSinhVien, maLop;
    private int kyHoc, soTinChi;

    public SinhVien_Lop(int maSinhVien, int maLop, int kyHoc, int soTinChi) {
        this.maSinhVien = maSinhVien;
        this.maLop = maLop;
        this.kyHoc = kyHoc;
        this.soTinChi = soTinChi;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public int getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(int kyHoc) {
        this.kyHoc = kyHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
