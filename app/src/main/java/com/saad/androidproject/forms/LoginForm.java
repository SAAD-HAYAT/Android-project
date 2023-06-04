package com.saad.androidproject.forms;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.Toast;

import androidx.room.Room;

import com.saad.androidproject.Activity.MainActivity;
import com.saad.androidproject.R;
import com.saad.androidproject.dao.UserDao;
import com.saad.androidproject.db.AppDatabase;
import com.saad.androidproject.entity.UserEntity;

public class LoginForm extends Activity {
<<<<<<< HEAD
    Button loginBtn = findViewById(R.id.loginbtn);
    EditText usernameTxt = findViewById(R.id.loginUsername);
        EditText passwordTxt = findViewById(R.id.loginPassword);
    CheckBox keepSignedInCheckBox;
    SharedPreferences sharedPreferences;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");

        // Autofill the EditText fields with saved username and password
        if (!savedUsername.isEmpty() && !savedPassword.isEmpty()) {
            usernameTxt.setText(savedUsername);
            passwordTxt.setText(savedPassword);
        }

=======
    Button loginBtn;
    EditText usernameTxt;
    EditText passwordTxt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginBtn = findViewById(R.id.loginbtn);
        usernameTxt = findViewById(R.id.loginUsername);
        passwordTxt = findViewById(R.id.loginPassword);
>>>>>>> 20f943c01d3f6e44e3425ff7a7932e5ffbd9e9c5
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordTxt.getText().toString();
                String username = usernameTxt.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (keepSignedInCheckBox.isChecked()) {
                    editor.putString("username", username);
                    editor.putString("password", password);
                } else {
                    editor.clear();
                }
                editor.apply();

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "app-database").allowMainThreadQueries().build();
                UserDao userDao = db.userDao();
                UserEntity pass = userDao.findByName(username);
                String orignalPassword = pass.userPassword;
<<<<<<< HEAD
                boolean isSignedIn = sharedPreferences.contains("username") && sharedPreferences.contains("password");
                if (isSignedIn) {
                    Intent i = new Intent(LoginForm.this, MainActivity.class);
                    startActivity(i);
                }
                else if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginForm.this,"field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals(orignalPassword)){
                    Toast.makeText(LoginForm.this,"login successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginForm.this, MainActivity.class);
                    startActivity(i);
                }

                else{
                    Toast.makeText(LoginForm.this,"invalid credentials",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginForm.this, LoginForm.class);
                    startActivity(i);
=======
                if (password.equals(orignalPassword)) {
                    Intent i = new Intent(LoginForm.this, MainActivity.class);
                    startActivity(i);
                } else {
                    passwordTxt.setError("invalid password");
>>>>>>> 20f943c01d3f6e44e3425ff7a7932e5ffbd9e9c5
                }

            }
        });

    }
}
