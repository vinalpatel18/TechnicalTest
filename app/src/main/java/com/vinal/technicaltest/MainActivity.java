package com.vinal.technicaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private ArrayList<Customer> CustomerDetails = new ArrayList<>();

    private ListView listView;

    private Customer[] Customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_item);

        populate();

    }

    private void populate() {
        Customers = new Customer[ApiCaller.getCustomers().length];
        Customers = ApiCaller.getCustomers();

        if (!CustomerDetails.isEmpty()){
            CustomerDetails.clear();
        }

        for (int i=0;i<Customers.length;i++){
            CustomerDetails.add(Customers[i]);
        }

        Custom_Adaptor adapter = new Custom_Adaptor(this, CustomerDetails);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> parent,
                                    View view, int position, long id) {

                populate();

            }
        });
    }
}
