package com.example.freefreelanse.activitys;

import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.freefreelanse.R;
import com.example.freefreelanse.app.AppController;
import com.example.freefreelanse.app.Menager;
import com.fasterxml.jackson.core.sym.Name;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class LentaActivity extends AppCompatActivity implements View.OnClickListener {
    String name;
    String phone;
    MyTask mt;
    Button button;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenta);
        mt = new MyTask();
        mt.execute();
        textView = findViewById(R.id.textView);
        textView.setText("Hello, "+name);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        //Button buttonGo = findViewById(R.id.button_go);
        //buttonGo.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Log.i("s", "e = " + Menager.EMAILE + "n = " + name);
                break;
        }




    }
    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

                DefaultHttpClient hc = new DefaultHttpClient();
                ResponseHandler response = new BasicResponseHandler();
                HttpGet http = new HttpGet("http://10.0.2.2:8080/demo/nameforemail?email="+ Menager.EMAILE);
                //получаем ответ от сервера
            try {
                name = (String) hc.execute(http, response);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
