package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());



        Intent intent = new Intent(this, NewsActivity.class);
        EditText edit = (EditText) findViewById(R.id.edit);


        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            intent.putExtra("login", edit.getText().toString());

            startActivity(intent);
                NewsListApplication app = (NewsListApplication) getApplicationContext();
                String login =edit.getText().toString();
                app.setLogin(login);

            }
        });








    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        //Intent startMain = new Intent(Intent.ACTION_MAIN);
        //startMain.addCategory(Intent.CATEGORY_HOME);
        //startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivity(startMain);

    }

}


