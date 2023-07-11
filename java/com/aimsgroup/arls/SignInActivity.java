package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aimsgroup.arls.database.DBHelper;


public class SignInActivity extends AppCompatActivity {
    EditText enterGmail, enterUser, enterPass;
    DBHelper myDB = new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }


    public void loginPage(View view) {
        Intent i= new Intent(SignInActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void registerNewUser(View view) {
        enterGmail = (EditText) findViewById(R.id.enterGmail);
        enterUser = (EditText) findViewById(R.id.enterUser);
        enterPass = (EditText) findViewById(R.id.enterPass);
//        users(id int primary key, username text , fullname text, gmail text , password text , attempts text )
        String getGmail = enterGmail.getText().toString();
        String getUser = enterUser.getText().toString();
        String getPass = enterPass.getText().toString();

        if( getGmail.equals("") || getUser.equals("")|| getPass.equals("")) {
            Toast.makeText(SignInActivity.this, "Input field can't be empty !", Toast.LENGTH_SHORT).show();
        } else {
            boolean getUserResult = myDB.checkUsernameIfExists(getUser);
            if(getUserResult){
                Toast.makeText(SignInActivity.this, "User is already Exists !", Toast.LENGTH_SHORT).show();

            } else {
                boolean isInserted = myDB.insertData(getUser, getUser.toUpperCase(),getGmail,getPass,3);
                if(isInserted){
                    Toast.makeText(SignInActivity.this, "Signed In Successfully !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this, ForgetPage.class);
                    String[] myStrings = new String[] {getGmail, "204060"};
                    intent.putExtra("data", myStrings);
                    startActivity(intent);

                } else {
                    Toast.makeText(SignInActivity.this, "Signed In Failed !", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}