package com.saad.androidproject.forms;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.room.Room;

import com.saad.androidproject.R;
import com.saad.androidproject.db.AppDatabase;

import java.time.ZoneId;

public class Signup extends Activity {
    Button signInBtn;
    EditText usernameTxt, emailTxt, passwordTxt, confirmPasswordTxt;
//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signInBtn = findViewById(R.id.txtbtn);
        usernameTxt = findViewById(R.id.usenameTxt);
        emailTxt = findViewById(R.id.emailTxt);
        passwordTxt = findViewById(R.id.passTxt);
        confirmPasswordTxt = findViewById(R.id.confirmPassTxt);

        signInBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String password = passwordTxt.getText().toString();
                String confirmPassword = confirmPasswordTxt.getText().toString();
//                if(password.equals(confirmPassword)){
//                    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                            AppDatabase.class, "database-name").build();
//                }
//                else {
//
//                }
            }
        });

    }
}
