package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private ListView lv;
        private  String[] cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adpCities = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,cities);
        lv = (ListView)  findViewById(R.id.listview);
        lv.setAdapter(adpCities);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView output = findViewById(R.id.lblOutput);
                String selectedCity = parent.getItemAtPosition(position).toString();
                output.setText("你是住在" + selectedCity);
                Toast.makeText(MainActivity.this, "你是住在: " + selectedCity, Toast.LENGTH_SHORT).show();
            }
        });
    }
}