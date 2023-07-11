package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MySales extends AppCompatActivity {
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sales);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString("username");
        }
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();

        ListView myListView = findViewById(R.id.myListView1);
        ArrayList<String> grocery = new ArrayList<>();

        grocery.add("W-Pet     1560   150.25  15000   31-Sep 20:24");
        grocery.add("G-Pet     1560   150.25  15000   31-Sep 20:24");
        grocery.add("M-PP      1560   150.25  15000   31-Sep 20:24");
        grocery.add("PP-T      1560   150.25  15000   31-Sep 20:24");
        grocery.add("C-HD      1560   150.25  15000   31-Sep 20:24");
        grocery.add("W-HD      1560   150.25  15000   31-Sep 20:24");
        grocery.add("FILM      1560   150.25  15000   31-Sep 20:24");
        grocery.add("OCC-A     1560   150.25  15000   31-Sep 20:24");
        grocery.add("OCC-B     1560   150.25  15000   31-Sep 20:24");
        grocery.add("PAPER     1560   150.25  15000   31-Sep 20:24");
        grocery.add("A-CAN     1560   150.25  15000   31-Sep 20:24");
        grocery.add("A-POT     1560   150.25  15000   31-Sep 20:24");
        grocery.add("E-WST     1560   150.25  15000   31-Sep 20:24");
        grocery.add("PC-BTL    1560   150.25  15000   31-Sep 20:24");
        grocery.add("W-Pet     1560   150.25  15000   31-Sep 20:24");
        grocery.add("G-Pet     1560   150.25  15000   31-Sep 20:24");
        grocery.add("M-PP      1560   150.25  15000   31-Sep 20:24");
        grocery.add("PP-T      1560   150.25  15000   31-Sep 20:24");
        grocery.add("C-HD      1560   150.25  15000   31-Sep 20:24");
        grocery.add("W-HD      1560   150.25  15000   31-Sep 20:24");
        grocery.add("FILM      1560   150.25  15000   31-Sep 20:24");
        grocery.add("OCC-A     1560   150.25  15000   31-Sep 20:24");
        grocery.add("OCC-B     1560   150.25  15000   31-Sep 20:24");
        grocery.add("PAPER     1560   150.25  15000   31-Sep 20:24");
        grocery.add("A-CAN     1560   150.25  15000   31-Sep 20:24");
        grocery.add("A-POT     1560   150.25  15000   31-Sep 20:24");
        grocery.add("E-WST     1560   150.25  15000   31-Sep 20:24");
        grocery.add("PC-BTL    1560   150.25  15000   31-Sep 20:24");



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grocery);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener((parent, view, position, ID) -> {
            parent.getChildAt(position).setBackgroundColor(Color.BLUE);
            String clickedValues = "ID: " + position + " "+ ((TextView) view).getText().toString();
            Toast.makeText(MySales.this, clickedValues,Toast.LENGTH_SHORT).show();
        });


    }






}