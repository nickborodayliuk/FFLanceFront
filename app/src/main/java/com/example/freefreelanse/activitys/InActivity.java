package com.example.freefreelanse.activitys;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.freefreelanse.R;
import com.example.freefreelanse.utils.Menager;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class InActivity extends AppCompatActivity implements View.OnClickListener {
    Button inButton;
    Button upButton;

    TextView email;
    TextView password;
    String emailString;
    String passwordString;

    String goodPass;
    MyTask myTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in);
        inButton = findViewById(R.id.in_button);
        upButton = findViewById(R.id.up_button);
        email = findViewById(R.id.email_text2);
        password = findViewById(R.id.password_text2);
        inButton.setOnClickListener(this);
        upButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.in_button:
                emailString = email.getText().toString();
                passwordString = "[\""+password.getText().toString()+"\"]";




                myTask = new MyTask();
                myTask.execute();

                if (passwordString.equals(goodPass)){
                    Menager.EMAILE = emailString;
                    Intent intent = new Intent(this, LentaActivity.class);
                    startActivity(intent);

                }else {
                    Log.i("Error", "poe" + goodPass + "    " +passwordString);



                }

                break;



            case  R.id.up_button:
                Intent intent2 = new Intent(this, UpActivity.class);
                startActivity(intent2);
                break;
        }

    }

    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            DefaultHttpClient hc = new DefaultHttpClient();
            ResponseHandler response = new BasicResponseHandler();
            HttpGet http = new HttpGet("http://10.0.2.2:8080/demo/passforemail?email="+ emailString);
            //получаем ответ от сервера
            try {
                goodPass = (String) hc.execute(http, response);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
