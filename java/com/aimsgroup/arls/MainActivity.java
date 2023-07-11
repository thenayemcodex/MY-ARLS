package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aimsgroup.arls.database.DBHelper;



public class MainActivity extends AppCompatActivity {
    EditText enterUser, enterPass;
    TextView forgetBtn;
    DBHelper myDB = new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        enterUser =  findViewById(R.id.enterUser);
        forgetBtn =  findViewById(R.id.forgerBtn);

        forgetBtn.setOnClickListener(view -> {
            String mail = myDB.getUserMail(enterUser.getText().toString());
            if(mail.equals("")) {
                Toast.makeText(this, "Enter Gmail/Username", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(MainActivity.this, mail, Toast.LENGTH_SHORT).show();
            }
        });

    }






    public void registrationPage(View view) {

        Intent i= new Intent(MainActivity.this, SignInActivity.class);
        startActivity(i);
    }


    public void loginButtonPressed(View view) {

        enterUser = findViewById(R.id.enterUser);
        enterPass = findViewById((R.id.enterPass));
        String username = enterUser.getText().toString();
        String password = enterPass.getText().toString();

        if(enterUser.getText().toString().equals("") || enterPass.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Username / Password can't be empty", Toast.LENGTH_SHORT).show();
        } else {
            boolean validUser = myDB.checkUserCredentials(username, password);
            if (validUser){
                Toast.makeText(MainActivity.this, "Log In successful !", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(MainActivity.this, HomePageActivity.class);
                i.putExtra("username", username);
                startActivity(i);
            } else {
                Toast.makeText(MainActivity.this, "Wrong Username/Password\nTry again.", Toast.LENGTH_SHORT).show();
            }
        }

    }





}