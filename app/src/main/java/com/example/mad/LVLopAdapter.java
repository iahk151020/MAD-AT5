package com.example.mad;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LVLopAdapter extends BaseAdapter {

    final ArrayList<Lop> listLop;

    public LVLopAdapter(ArrayList<Lop> listLop) {
        this.listLop = listLop;
    }

    @Override
    public int getCount() {
        return listLop.size();
    }

    @Override
    public Object getItem(int i) {
        return listLop.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listLop.get(i).getMaLop();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewLop;

        if (view == null) {
            viewLop = View.inflate(viewGroup.getContext(), R.layout.lop_list_item, null);
        } else viewLop = view;

        Lop lop = (Lop) getItem(i);

        ((TextView) viewLop.findViewById(R.id.tv_lop_item_ma_lop)).setText(String.valueOf(lop.getMaLop()));
        ((TextView) viewLop.findViewById(R.id.tv_lop_item_ten_lop)).setText(lop.getTenLop());
        ((TextView) viewLop.findViewById(R.id.tv_lop_mo_ta)).setText(lop.getMoTa());


        return viewLop;
    }
}
