package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aimsgroup.arls.database.DBHelper;

public class ResetPasswordPage extends AppCompatActivity {
    DBHelper myDB = new DBHelper(this);
    String myStrings;
    EditText userPass, userCPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_page);
        Intent intent = getIntent();
        myStrings = intent.getStringExtra("gmail");
    }

    public void resetPassword(View view) {
        userCPass = (EditText) findViewById(R.id.entercPass);
        userPass = (EditText) findViewById(R.id.enterPass);
        String pass = userPass.getText().toString();
        String cpass = userCPass.getText().toString();

        if (pass.equals(cpass)){
            if(pass.equals("")){
                Toast.makeText(ResetPasswordPage.this, "Password can not be Empty !", Toast.LENGTH_SHORT).show();
            } else {
                boolean resetResult = myDB.ForgetPassword(pass,myStrings);
                if(resetResult){
                    Toast.makeText(ResetPasswordPage.this, "Reset Password successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetPasswordPage.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(ResetPasswordPage.this, "Reset Password Failed", Toast.LENGTH_SHORT).show();
                }

            }
        }else {
            Toast.makeText(ResetPasswordPage.this, "Password doesn't match !", Toast.LENGTH_SHORT).show();
        }
    }


    public void loginPage(View view) {
        Toast.makeText(ResetPasswordPage.this, "Going to Login page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ResetPasswordPage.this, MainActivity.class);
        startActivity(intent);
    }
}