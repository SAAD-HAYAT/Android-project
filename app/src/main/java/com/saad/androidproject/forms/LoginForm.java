package com.saad.androidproject.forms;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.saad.androidproject.R;

public class LoginForm extends Activity {
    Button loginBtn;
    EditText username ,password;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginBtn = findViewById(R.id.loginbtn);
        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);

    }
}
