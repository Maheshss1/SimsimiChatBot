package com.example.mahesh.simsimichatbot;

import android.Manifest;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mahesh.simsimichatbot.adapters.ChatAdapter;
import com.example.mahesh.simsimichatbot.model.ChatBot;
import com.example.mahesh.simsimichatbot.model.ChatModel;
import com.example.mahesh.simsimichatbot.support.HttpDataHandler;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    FloatingActionButton fab;
    List<ChatModel> chatModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            requestPermissions(new String[]{Manifest.permission.INTERNET},34);

        chatModelList = new ArrayList<>();
        listView = findViewById(R.id.chat_list);
        editText = findViewById(R.id.message);
        fab = findViewById(R.id.send);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                ChatModel chatModel = new ChatModel(text, true);
                chatModelList.add(chatModel);
                new SimsimiAPI().execute(chatModelList);


                editText.setText("");
            }
        });

    }

    private class SimsimiAPI extends AsyncTask<List<ChatModel>, Void, String>{

        String stream = null;
        List<ChatModel> models;
        String text = editText.getText().toString();

        @Override
        protected String doInBackground(List<ChatModel>... lists) {
            models = lists[0];
            String url = String.format("http://sandbox.api.simsimi.com/request.p?key=%s&lc=en&ft=1.0&text=%s",getString(R.string.chat_bot_key),text);
            HttpDataHandler dataHandler = new HttpDataHandler();
            stream = dataHandler.getHTTPData(url);

            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            ChatBot chatBot = gson.fromJson(s, ChatBot.class);

            ChatModel chatModel = new ChatModel(chatBot.getResponse(),false);
            chatModelList.add(chatModel);
            ChatAdapter chatAdapter = new ChatAdapter(chatModelList, MainActivity.this);
            listView.setAdapter(chatAdapter);
        }
    }
}
