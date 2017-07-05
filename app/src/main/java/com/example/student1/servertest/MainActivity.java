package com.example.student1.servertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    final String MSG_LOADING = "Loading...";
    final String MSG_ERROR = "Error...";

    EditText editText;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://avalonstudio.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MessageRequest req = retrofit.create(MessageRequest.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // editText = (EditText)findViewById(R.id.editText);
        final ListView messages = (ListView) findViewById(R.id.list_item);


        //async
        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //editText.setText(MSG_LOADING);

                Call<Messages> call = req.getPersons();

                call.enqueue(new Callback<Messages>() {
                    @Override
                    public void onResponse(Call<Messages> call, Response<Messages> response) {
                       // editText.setText(response.body().toString());
                        ArrayList<HashMap<String, Object>> myArrList = new ArrayList<>();
                        HashMap<String, Object> map;
                        Iterator iterator = response.body().persons.iterator();
                        while(iterator.hasNext()){
                            Message msg = (Message)iterator.next();
                            map = new HashMap<>();
                            map.put("Id", msg.id);
                            map.put("Date", msg.date);
                            map.put("Msg", msg.text);
                            myArrList.add(map);

                        }
                        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), myArrList,
                                R.layout.forum_adapter, new String[] { "MemberID", "Date",
                                "Text" }, new int[] { R.id.ColMemberID, R.id.ColDate,
                                R.id.ColMessage });
                        messages.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<Messages> call, Throwable t) {
                      //  editText.setText(MSG_ERROR);
                    }
                });
            }
        });


    }
}

