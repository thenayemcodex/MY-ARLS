package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPage extends AppCompatActivity {
    EditText enterOTP = (EditText) findViewById(R.id.enterOTP);
    String[] myStrings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_page);
        Intent intent = getIntent();
        myStrings = intent.getStringArrayExtra("data");
    }

    public void loginPage(View view) {
        String Otp = enterOTP.getText().toString();
        if (Otp.equals(myStrings[1])) {
            Toast.makeText(ForgetPage.this, "Security check successful !", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ForgetPage.this, ResetPasswordPage.class);
            i.putExtra("gmail",myStrings[0]);
            startActivity(i);
        }else {
            Toast.makeText(ForgetPage.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetUserPassword(View view) {
        Toast.makeText(ForgetPage.this, "Working", Toast.LENGTH_SHORT).show();
    }
}