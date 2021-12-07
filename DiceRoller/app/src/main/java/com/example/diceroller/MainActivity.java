package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.button);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast toast = Toast.makeText(MainActivity.this, "Dé lancé!", Toast.LENGTH_SHORT);
                //toast.show();
                //Toast.makeText(this, "Dé lancé!", Toast.LENGTH_SHORT).show()


                EditText editText =(EditText) findViewById(R.id.face);
                String smax = editText.getText().toString();
                int max= Integer.valueOf(smax);
                int min=1;
                //int max=6;


                Random random = new Random();

                int value = random.nextInt(max+min-1) + min;
                String svalue = String.valueOf(value);

                int value1 = random.nextInt(max+min-1) + min;
                String svalue1 = String.valueOf(value1);


                TextView textView = (TextView) findViewById(R.id.textview);
                textView.setText(svalue);

                TextView textView1 = (TextView) findViewById(R.id.textview1);
                textView1.setText(svalue1);


            }
        });


    }

}