package com.example.freefreelanse.activitys;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.freefreelanse.R;
import com.example.freefreelanse.utils.Menager;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class LentaActivity extends AppCompatActivity implements View.OnClickListener {


    MyTask mt;
    Button filtrButton;
    Button addOrder;
    CheckBox prBox;
    CheckBox dsBox;
    CheckBox videoBox;
    CheckBox gameBox;
    CheckBox phBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenta);
       // mt = new MyTask();
       // mt.execute();
        filtrButton = findViewById(R.id.filtr);
        filtrButton.setOnClickListener(this);

        addOrder = findViewById(R.id.addOrder);
        addOrder.setOnClickListener(this);

        prBox = findViewById(R.id.checkPrograming);
        dsBox = findViewById(R.id.disignerBox);
        videoBox = findViewById(R.id.videoBox4);
        gameBox = findViewById(R.id.gameBox);
        phBox = findViewById(R.id.photoBox);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        menu.add("Мій кабінет");
        menu.add("Налаштування");
        menu.add("Мої замовлення");
        menu.add("Мої контракти");
        menu.add("Вийти");

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getTitle().toString()) {
            case "Мій кабінет":
                Intent intent = new Intent(this, MyPageAtcivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.filtr:
                if(!Menager.BOXVISIBLE) {
                    prBox.setVisibility(View.VISIBLE);
                    dsBox.setVisibility(View.VISIBLE);
                    videoBox.setVisibility(View.VISIBLE);
                    phBox.setVisibility(View.VISIBLE);
                    gameBox.setVisibility(View.VISIBLE);
                    Menager.BOXVISIBLE = true;
                }else {
                    prBox.setVisibility(View.INVISIBLE);
                    dsBox.setVisibility(View.INVISIBLE);
                    videoBox.setVisibility(View.INVISIBLE);
                    phBox.setVisibility(View.INVISIBLE);
                    gameBox.setVisibility(View.INVISIBLE);
                    Menager.BOXVISIBLE = false;
                }
                break;
            case R.id.addOrder:
                Intent intent = new Intent(this, AddOrderActivity.class);
                startActivity(intent);



        }

    }
    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
                DefaultHttpClient hc = new DefaultHttpClient();
                ResponseHandler response = new BasicResponseHandler();
                //получаем ответ от сервера
                HttpGet http = new HttpGet("http://10.0.2.2:8080/demo/nameforemail?email="+ Menager.EMAILE);
            try {
                String name = (String) hc.execute(http, response);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
