package com.saad.androidproject.forms;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.room.Room;

import com.saad.androidproject.Activity.SplashActivity;
import com.saad.androidproject.R;
import com.saad.androidproject.dao.UserDao;
import com.saad.androidproject.db.AppDatabase;
import com.saad.androidproject.entity.UserEntity;

import java.time.ZoneId;

public class Signup extends Activity {
    Button signInBtn;
    EditText usernameTxt;
    EditText emailTxt;
    EditText passwordTxt;
    EditText confirmPasswordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signInBtn = findViewById(R.id.txtbtn);
        usernameTxt = findViewById(R.id.usenameTxt);
        emailTxt = findViewById(R.id.emailTxt);
        passwordTxt = findViewById(R.id.passTxt);
        confirmPasswordTxt = findViewById(R.id.confirmPassTxt);
        signInBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String password = passwordTxt.getText().toString();
                String username = usernameTxt.getText().toString();
                String email = emailTxt.getText().toString();
                String confirmPassword = confirmPasswordTxt.getText().toString();
                if (password.equals(confirmPassword)) {
                    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                            AppDatabase.class, "app-database").allowMainThreadQueries().build();
                    UserDao userDao = db.userDao();
                    int count = userDao.getUserCount();
                    count++;
                    UserEntity user = new UserEntity(count, username, email, password);
                    userDao.insertUser(user);
                    Intent i = new Intent(Signup.this, LoginForm.class);
                    startActivity(i);
                } else {
                    passwordTxt.setError("password does not match");
                }
            }
        });

    }
}
