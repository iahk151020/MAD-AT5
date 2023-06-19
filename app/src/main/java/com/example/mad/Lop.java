package com.example.mad;

public class Lop {
    private int maLop;
    private String tenLop, moTa;

    public Lop(int maLop, String tenLop, String moTa) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.moTa = moTa;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
