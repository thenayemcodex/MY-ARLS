package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aimsgroup.arls.database.BidsDatabase;

public class BidOnMaterials extends AppCompatActivity {
    String username;
    BidsDatabase myBid = new BidsDatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_on_materials);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString("username");
            Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
        }
    }

    public void goToPreviousPage() {
        Intent intent = new Intent(BidOnMaterials.this, HomePageActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    @SuppressLint("SimpleDateFormat")
    public void processMyBIds(View view) {


        Button seeButton = (Button) view;
        String getProcessButtonTag = seeButton.getTag().toString();
        if(getProcessButtonTag.length() > 0){
            Toast.makeText(this, getProcessButtonTag, Toast.LENGTH_SHORT).show();
            switch (getProcessButtonTag) {
                case "wp": {
                    boolean result = myBid.insertBidsData("nayem", "White Pet", "wp", 1500, "Can you be my permanent salesman", "0566408371", "nayeme19@gmail.com", "20-Sep-2023 20:20", "false");
                    Log.d("result", "processMyBIds: " + result);
                    if (result) {
                        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "gp": {
                    boolean result = myBid.insertBidsData("tahsan", "green Pet", "gp", 1550, "Can you be my permanent salesman", "0566408371", "nayeme19@gmail.com", "20-Sep-2023 20:20", "false");
                    Log.d("result", "processMyBIds: " + result);
                    if (result) {
                        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
                case "mpp": {
                    boolean result = myBid.insertBidsData("ruhul amin", "mix pp", "mpp", 870, "Can you be my permanent salesman", "0566408371", "nayeme19@gmail.com", "20-Sep-2023 20:20", "false");
                    Log.d("result", "processMyBIds: " + result);
                    if (result) {
                        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
            }
        }
    }



}