package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());



        NewsListApplication app = (NewsListApplication) getApplicationContext();
        String login = app.getLogin();

        TextView textView =(TextView) findViewById(R.id.textview1);
        textView.setText(login);

        Intent intent = new Intent(this, NewsActivity.class);

        Button ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent);

            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //TODO
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }

}