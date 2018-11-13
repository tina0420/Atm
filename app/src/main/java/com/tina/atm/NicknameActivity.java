package com.tina.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
    }

    public void nickname(View view){
        EditText edNickname = findViewById(R.id.ed_nickname);
        String nickname = edNickname.getText().toString();
        getSharedPreferences("NICKNAME",MODE_PRIVATE)
                .edit()
                .putString("NickName",nickname)
                .apply();
        Intent next = new Intent(this,AgeActivity.class);
        startActivity(next);
    }

}
