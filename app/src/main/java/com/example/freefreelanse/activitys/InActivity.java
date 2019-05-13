package com.example.freefreelanse.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.freefreelanse.R;

public class InActivity extends AppCompatActivity implements View.OnClickListener {
    Button inButton;
    Button upButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in);
        inButton = findViewById(R.id.in_button);
        upButton = findViewById(R.id.up_button);
        inButton.setOnClickListener(this);
        upButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.in_button:
                Intent intent = new Intent(this, LentaActivity.class);//zminuty!!!
                startActivity(intent);
                break;

            case  R.id.up_button:
                Intent intent2 = new Intent(this, UpActivity.class);
                startActivity(intent2);
                break;
        }

    }
}
