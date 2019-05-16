package com.example.freefreelanse.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.freefreelanse.R;
import com.example.freefreelanse.utils.Menager;

public class AddOrderActivity extends AppCompatActivity implements View.OnClickListener {
    Button publicOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        publicOrder = findViewById(R.id.publicOrder);
        publicOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.publicOrder:

                Intent intent = new Intent(this, LentaActivity.class);
                startActivity(intent);

        }
    }
}
