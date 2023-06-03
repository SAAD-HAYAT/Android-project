package com.saad.androidproject.forms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.room.Room;

import com.saad.androidproject.Activity.MainActivity;
import com.saad.androidproject.R;
import com.saad.androidproject.dao.UserDao;
import com.saad.androidproject.db.AppDatabase;
import com.saad.androidproject.entity.UserEntity;

public class LoginForm extends Activity {
    Button loginBtn = findViewById(R.id.loginbtn);
    EditText usernameTxt = findViewById(R.id.loginUsername);
        EditText passwordTxt = findViewById(R.id.loginPassword);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordTxt.getText().toString();
                String username = usernameTxt.getText().toString();
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "app-database").allowMainThreadQueries().build();
                UserDao userDao = db.userDao();
                UserEntity pass = userDao.findByName(username);
                String orignalPassword = pass.userPassword;
                if(password.equals(orignalPassword)){
                    Intent i = new Intent(LoginForm.this, MainActivity.class);
                    startActivity(i);
                }
                else{
                    passwordTxt.setError("invalid password");
                }

            }
        });

    }
}
