package com.example.ustc.healthreps.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.ustc.healthreps.R;
import com.example.ustc.healthreps.model.Medicine;

import java.util.List;

/**
 * Created by hzy on 2016/1/11.
 */
public class TabMedicineAdapter extends BaseAdapter{
    private List<Medicine> list;
    private LayoutInflater inflater;

    public TabMedicineAdapter(Context context,List<Medicine> list){
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        Medicine medicine = (Medicine) this.getItem(pos);
        ViewHolder viewHolder;
        if(view == null)
        {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.medic_info_header, null);
            viewHolder.mMedicName = (TextView)view.findViewById(R.id.medicine_name);
            viewHolder.mMedicCategory = (TextView)view.findViewById(R.id.mediine_kind);
            viewHolder.mMedicBehavior = (TextView)view.findViewById(R.id.medicine_away);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mMedicName.setText(medicine.name);
        viewHolder.mMedicCategory.setText(medicine.category);
        viewHolder.mMedicBehavior.setText(medicine.usage);

        viewHolder.mMedicName.setTextColor(Color.BLACK);
        viewHolder.mMedicCategory.setTextColor(Color.BLACK);
        viewHolder.mMedicBehavior.setTextColor(Color.BLACK);

        return view;
    }

    public static class ViewHolder{
        public TextView mMedicName;
        public TextView mMedicCategory;
        public TextView mMedicBehavior;
    }
}
