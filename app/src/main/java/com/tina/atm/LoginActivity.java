package com.tina.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        String userid = ((EditText)findViewById(R.id.ed_account)).getText().toString();
        String userpassword = ((EditText)findViewById(R.id.ed_password)).getText().toString();
        if("jack".equals(userid) && "0000".equals(userpassword)){
            finish();
        }
    }
}
