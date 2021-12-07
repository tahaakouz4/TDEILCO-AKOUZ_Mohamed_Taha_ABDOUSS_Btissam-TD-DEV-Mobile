package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());




        Intent intent = getIntent();
        String login = null;
        if (intent.hasExtra("login")) {
            login = intent.getStringExtra("login");

        }

        TextView textView =(TextView) findViewById(R.id.textview);
        textView.setText(login);

        Intent intent1 = new Intent(this, DetailsActivity.class);

        Button details = (Button) findViewById(R.id.details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent1);

            }
        })
        ;


        Intent intent2 = new Intent(this, LoginActivity.class);

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent2);

            }
        });
        Button about = (Button) findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);


            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        moveTaskToBack(true);
        //finish();
        //Intent startMain = new Intent(Intent.ACTION_MAIN);
        //startMain.addCategory(Intent.CATEGORY_HOME);
        //startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivity(startMain);

    }

}