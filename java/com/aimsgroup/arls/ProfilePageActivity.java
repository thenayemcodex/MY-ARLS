package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfilePageActivity extends AppCompatActivity {

    EditText fullName, userEID, userNationality, reference, ownerDrivingLicense, businessName, businessCity, businessArea, businessStreet , businessType, businessStructure,shareHolder,businessLicense;
    ImageView profile_image, saveBtn;
    String username;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            username = bundle.getString("username");
        }



        profile_image        = (ImageView)findViewById(R.id.profile_image);

        fullName             = (EditText) findViewById(R.id.fullname);
        userEID              = (EditText) findViewById(R.id.user_eid);
        userNationality      = (EditText) findViewById(R.id.user_nationality);
        reference            = (EditText) findViewById(R.id.reference);
        ownerDrivingLicense  = (EditText) findViewById(R.id.owner_driving_license);
        businessName         = (EditText) findViewById(R.id.business_name);
        businessCity         = (EditText) findViewById(R.id.business_city);
        businessArea         = (EditText) findViewById(R.id.business_area);
        businessStreet       = (EditText) findViewById(R.id.business_street);
        businessType         = (EditText) findViewById(R.id.business_type);
        businessStructure    = (EditText) findViewById(R.id.business_structure);
        shareHolder          = (EditText) findViewById(R.id.share_holder);
        businessLicense      = (EditText) findViewById(R.id.business_license);


        fullName.setInputType(0);
        userEID.setInputType(0);
        userNationality.setInputType(0);
        reference.setInputType(0);
        ownerDrivingLicense.setInputType(0);
        businessName.setInputType(0);
        businessCity.setInputType(0);
        businessArea.setInputType(0);
        businessStreet.setInputType(0);
        businessType.setInputType(0);
        businessStructure.setInputType(0);
        shareHolder.setInputType(0);
        businessLicense.setInputType(0);
    }

    public void updateProfileDetails(View view) {
        saveBtn = (ImageView) findViewById(R.id.saveBtn);
        saveBtn.setVisibility(View.VISIBLE);

        fullName             = (EditText) findViewById(R.id.fullname);
        userEID              = (EditText) findViewById(R.id.user_eid);
        userNationality      = (EditText) findViewById(R.id.user_nationality);
        reference            = (EditText) findViewById(R.id.reference);
        ownerDrivingLicense  = (EditText) findViewById(R.id.owner_driving_license);
        businessName         = (EditText) findViewById(R.id.business_name);
        businessCity         = (EditText) findViewById(R.id.business_city);
        businessArea         = (EditText) findViewById(R.id.business_area);
        businessStreet       = (EditText) findViewById(R.id.business_street);
        businessType         = (EditText) findViewById(R.id.business_type);
        businessStructure    = (EditText) findViewById(R.id.business_structure);
        shareHolder          = (EditText) findViewById(R.id.share_holder);
        businessLicense      = (EditText) findViewById(R.id.business_license);


        fullName.setInputType(1);
        userEID.setInputType(1);
        userNationality.setInputType(1);
        reference.setInputType(1);
        ownerDrivingLicense.setInputType(1);
        businessName.setInputType(1);
        businessCity.setInputType(1);
        businessArea.setInputType(1);
        businessStreet.setInputType(1);
        businessType.setInputType(1);
        businessStructure.setInputType(1);
        shareHolder.setInputType(1);
        businessLicense.setInputType(1);
    }

    public void signOutBtn(View view) {
        Intent i= new Intent(ProfilePageActivity.this, MainActivity.class);
        i.putExtra("username", username);
        startActivity(i);
    }



    public void saveButton(View view) {
        Intent i= new Intent(ProfilePageActivity.this, HomePageActivity.class);
        i.putExtra("username", username);
        startActivity(i);
    }
}