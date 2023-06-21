package com.example.mad;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LVSinhVienAdapter extends BaseAdapter {

    final List<SinhVien> listSinhVien;

    public LVSinhVienAdapter(List<SinhVien> listSinhVien) {
        this.listSinhVien = listSinhVien;
    }

    @Override
    public int getCount() {
        return listSinhVien.size();
    }

    @Override
    public Object getItem(int i) {
        return listSinhVien.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listSinhVien.get(i).getMaSinhVien();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewSinhVien;

        if (view == null) {
            viewSinhVien = View.inflate(viewGroup.getContext(), R.layout.sinh_vien_list_item, null);
        } else viewSinhVien = view;

        SinhVien sinhvien = (SinhVien) getItem(i);

        ((TextView) viewSinhVien.findViewById(R.id.tv_sv_item_ten)).setText(sinhvien.getTen());
        ((TextView) viewSinhVien.findViewById(R.id.tv_sv_item_masv)).setText(String.valueOf(sinhvien.getMaSinhVien()));
        ((TextView) viewSinhVien.findViewById(R.id.tv_sv_item_nam_hoc)).setText(String.valueOf(sinhvien.getNamHoc()));
        ((TextView) viewSinhVien.findViewById(R.id.tv_sv_item_nam_sinh)).setText(String.valueOf(sinhvien.getNamSinh()));
        ((TextView) viewSinhVien.findViewById(R.id.tv_sv_item_que)).setText(sinhvien.getQueQuan());

        return viewSinhVien;
    }
}
