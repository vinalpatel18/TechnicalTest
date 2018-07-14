package com.vinal.technicaltest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vinalpatel on 2018-07-14.
 */

public class Custom_Adaptor extends BaseAdapter {

    private Activity activecontext;

    private ArrayList<Customer> CustomerDetails = new ArrayList<>();

    public Custom_Adaptor(Activity context,
                          ArrayList<Customer> CustomerDetails ) {
        activecontext = context;
        this.CustomerDetails = CustomerDetails;
    }

    @Override
    public int getCount() {
        return CustomerDetails.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(activecontext).inflate(
                    R.layout.columlayout, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view
                    .findViewById(R.id.name);
            viewHolder.number = (TextView) view
                    .findViewById(R.id.contact);

            view.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.number.setText(CustomerDetails.get(i).getPhoneNumber());
        viewHolder.name.setText(CustomerDetails.get(i).getName());


        return view;
    }

    public class ViewHolder {
        public TextView name, number;

    }
}
