package com.saad.androidproject.forms;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.room.Room;

import com.saad.androidproject.Activity.SplashActivity;
import com.saad.androidproject.R;
import com.saad.androidproject.dao.UserDao;
import com.saad.androidproject.db.AppDatabase;
import com.saad.androidproject.entity.UserEntity;

import java.time.ZoneId;

public class Signup extends Activity {
    Button signInBtn = findViewById(R.id.txtbtn);
    EditText usernameTxt = findViewById(R.id.usenameTxt);
    EditText emailTxt = findViewById(R.id.emailTxt);
    EditText passwordTxt = findViewById(R.id.passTxt);
    EditText confirmPasswordTxt = findViewById(R.id.confirmPassTxt);
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        sharedPreferences = getSharedPreferences("login_prefs", MODE_PRIVATE);

        signInBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String password = passwordTxt.getText().toString();
                String username = usernameTxt.getText().toString();
                String email = emailTxt.getText().toString();
                String confirmPassword = confirmPasswordTxt.getText().toString();
                if(username.isEmpty() && email.isEmpty() && password.isEmpty() && confirmPassword.isEmpty() ){
                    Toast.makeText(Signup.this,"field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals(confirmPassword)){
                    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                            AppDatabase.class, "app-database").allowMainThreadQueries().build();
                    UserDao userDao = db.userDao();
                     int count = userDao.getUserCount();
                     count++;
                    UserEntity user = new UserEntity(count,username,email,password);
                    userDao.insertUser(user);
                    Toast.makeText(Signup.this,"Sign up successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Signup.this, LoginForm.class);
                    startActivity(i);
                }

            }
        });

    }
}
