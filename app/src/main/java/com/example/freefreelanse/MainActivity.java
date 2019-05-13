package com.example.freefreelanse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.freefreelanse.activitys.InActivity;
import com.example.freefreelanse.activitys.UpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, InActivity.class);
        startActivity(intent);
    }
}
