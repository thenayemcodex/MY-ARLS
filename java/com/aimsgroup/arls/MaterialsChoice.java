package com.aimsgroup.arls;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aimsgroup.arls.database.DBHelper;

import  java.time.LocalDate;

public class MaterialsChoice extends AppCompatActivity {
    String username;
    ImageView whitePet, greenPet, mixPP, ppTokri, colorHD, whiteHD,film, occA, occB, paper, steel, aCan, aPot, eWaste, pcBottle;
    DBHelper myDB = new DBHelper(this);
    boolean isSeen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials_choice);

    }

    public void seeMoreDetailButton(View view) {
//        getting image views from xml
        whitePet = (ImageView) findViewById(R.id.wp_bale);
        greenPet = (ImageView) findViewById(R.id.gp_bale);
        mixPP = (ImageView) findViewById(R.id.mpp_bale);
        ppTokri= (ImageView) findViewById(R.id.ppt_bale);
        colorHD = (ImageView) findViewById(R.id.chd_bale);
        whiteHD = (ImageView) findViewById(R.id.whd_bale);
        film  = (ImageView) findViewById(R.id.fm_bale);
        occA = (ImageView) findViewById(R.id.oca_bale);
        occB = (ImageView) findViewById(R.id.ocb_bale);
        paper = (ImageView) findViewById(R.id.pr_bale);
        steel = (ImageView)findViewById(R.id.steel);
        aCan = (ImageView) findViewById(R.id.acn_bale);
        aPot = (ImageView) findViewById(R.id.apt_bale);
        eWaste = (ImageView) findViewById(R.id.ew_bale);
        pcBottle = (ImageView) findViewById(R.id.pc_bale);



//        get text view tag
        TextView seeButton = (TextView) view;
        String getSeeButtonTag = seeButton.getTag().toString();


        if(getSeeButtonTag.length() > 0) {
            Toast.makeText(MaterialsChoice.this, getSeeButtonTag, Toast.LENGTH_SHORT).show();
            switch (getSeeButtonTag) {
                case "wp":
                    if (!isSeen) { // isSeen = false [default]
                        whitePet.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        whitePet.setVisibility(View.GONE);
                        isSeen = false;
                    }

                    break;
                case "gp":
                    if (!isSeen) { // isSeen = false [default]
                        greenPet.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        greenPet.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "mpp":
                    if (!isSeen) { // isSeen = false [default]
                        mixPP.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        mixPP.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "ppt":
                    if (!isSeen) { // isSeen = false [default]
                        ppTokri.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        ppTokri.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "chd":
                    if (!isSeen) { // isSeen = false [default]
                        colorHD.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        colorHD.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "whd":
                    if (!isSeen) { // isSeen = false [default]
                        whiteHD.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        whiteHD.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "fm":
                    if (!isSeen) { // isSeen = false [default]
                        film.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        film.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "oca":
                    if (!isSeen) { // isSeen = false [default]
                        occA.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        occA.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "ocb":
                    if (!isSeen) { // isSeen = false [default]
                        occB.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        occB.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "pr":
                    if (!isSeen) { // isSeen = false [default]
                        paper.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        paper.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "sl":
                    if (!isSeen) { // isSeen = false [default]
                        steel.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        steel.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;

                case "acn":
                    if (!isSeen) { // isSeen = false [default]
                        aCan.setVisibility(View.VISIBLE);
                        isSeen = true;
                    } else {
                        aCan.setVisibility(View.GONE);
                        isSeen = false;
                    }
                    break;
                case "apt":
                    Toast.makeText(this, "Alu-Pot Bales Unavaieble", Toast.LENGTH_SHORT).show();
                    break;
                case "ew":
                    Toast.makeText(this, "E-Waste Bales Unavaieble", Toast.LENGTH_SHORT).show();
                    break;
                case "pc":
                    Toast.makeText(this, "PC Bottle Bales Unavaieble", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(MaterialsChoice.this, "Failed to show bales", Toast.LENGTH_SHORT).show();
                    break;
            }

        } else {
            Toast.makeText(MaterialsChoice.this, "Failed to get Tag", Toast.LENGTH_SHORT).show();
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addToCardButton(View view) {
//        LocalTime getDate = LocalTime.now();
        LocalDate getDate = LocalDate.now();


        //        get text view tag
        TextView seeButton = (TextView) view;
        String getSeeButtonTag = seeButton.getTag().toString();
        
        if(getSeeButtonTag.length() > 0) {
            Toast.makeText(MaterialsChoice.this, getSeeButtonTag, Toast.LENGTH_SHORT).show();
            switch (getSeeButtonTag) {
                case "wp": {
                    boolean isInserted = myDB.insertCartData(username,"White Pet", "wp", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "gp": {
                    boolean isInserted = myDB.insertCartData(username,"Green Pet", "gp", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "mpp": {
                    boolean isInserted = myDB.insertCartData(username,"Mix PP", "mpp", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "ppt": {
                    boolean isInserted = myDB.insertCartData(username,"PP Tokri", "ppt", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "chd": {
                    boolean isInserted = myDB.insertCartData(username,"Color HD", "chd", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "whd": {
                    boolean isInserted = myDB.insertCartData(username,"White HD", "whd", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "fm": {
                    boolean isInserted = myDB.insertCartData(username,"Film", "fm", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "oca": {
                    boolean isInserted = myDB.insertCartData(username,"OCC A Grade", "oca", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "ocb": {
                    boolean isInserted = myDB.insertCartData(username,"OCC B Grade", "ocb", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "pr": {
                    boolean isInserted = myDB.insertCartData(username,"Mix Paper", "pr", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "sl": {
                    boolean isInserted = myDB.insertCartData(username,"Metal Loose", "sl", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "acn": {
                    boolean isInserted = myDB.insertCartData(username,"Aluminium Can", "acn", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "apt": {
                    boolean isInserted = myDB.insertCartData(username,"Aluminium Pot", "apt", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "ew": {
                    boolean isInserted = myDB.insertCartData(username,"Electrical Waste", "ew", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case "pc": {
                    boolean isInserted = myDB.insertCartData(username,"PC Bottle", "pc", String.valueOf(getDate));
                    if (isInserted) {
                        Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed !", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                default:
                    Toast.makeText(this, "Failed to AddCart", Toast.LENGTH_SHORT).show();
                    break;
            }

        } else {
            Toast.makeText(MaterialsChoice.this, "Error occurred !", Toast.LENGTH_SHORT).show();
        }

    }
}