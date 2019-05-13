package com.example.freefreelanse.activitys;

import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.freefreelanse.R;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class UpActivity extends AppCompatActivity implements View.OnClickListener {
    TextView fullName;
    TextView email;
    TextView pass;
    TextView phone;
    Button up_button;
    MyTask myTask;

    String fullNameString;
    String emailString;
    String passString;
    String phoneString;
    String string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_activity);


        fullName = findViewById(R.id.full_name);
        email = findViewById(R.id.email_text);
        phone = findViewById(R.id.phone_text);
        pass = findViewById(R.id.new_password);
        up_button = findViewById(R.id.in_up);
        up_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        myTask = new MyTask();

        switch (v.getId()) {
            case R.id.in_up:

                fullNameString = (String) fullName.getText().toString();
                emailString = (String) email.getText().toString();
                phoneString = (String) phone.getText().toString();
                passString = (String) pass.getText().toString();


                myTask.execute();
                Intent intent = new Intent(this, LentaActivity.class);
                startActivity(intent);

        }


    }


    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {



            DefaultHttpClient hc = new DefaultHttpClient();
            ResponseHandler response = new BasicResponseHandler();
            HttpGet http = new HttpGet("http://10.0.2.2:8080/demo/add?name="+fullNameString+"&email="+emailString+"&phone="+phoneString+"&password="+passString);
            //получаем ответ от сервера
            try {
                string = (String) hc.execute(http, response);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
