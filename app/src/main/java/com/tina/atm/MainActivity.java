package com.tina.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 100;
    Boolean logon = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(! logon){
            Intent intent = new Intent(this,LoginActivity.class);
            //startActivity(intent);
            startActivityForResult(intent,RC_LOGIN);
        }

        //data
        listView();

    }

    private void listView() {
        List<String> fruits = Arrays.asList("香蕉","蘋果","芭樂");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN){
            if(resultCode != RESULT_OK){
                finish();
            }else{
                logon = true;
                String nickname = getSharedPreferences("user",MODE_PRIVATE)
                        .getString("NICKNAME",null);
                int age = getSharedPreferences("user",MODE_PRIVATE)
                        .getInt("AGE",0);
                int gender = getSharedPreferences("user",MODE_PRIVATE)
                        .getInt("GENDER",0);

                if(nickname == null || age == 0 || gender == 0 ){
                    Intent nick = new Intent(this,NicknameActivity.class);
                    startActivity(nick);
                }
            }
        }
    }
}
