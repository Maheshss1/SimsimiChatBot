package com.example.mahesh.simsimichatbot.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mahesh.simsimichatbot.R;
import com.example.mahesh.simsimichatbot.model.ChatModel;
import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

public class ChatAdapter extends BaseAdapter {

    private List<ChatModel> chatModels;
    private Context context;

    public ChatAdapter(List<ChatModel> chatModels, Context context) {
        this.chatModels = chatModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chatModels.size();
    }

    @Override
    public Object getItem(int i) {
        return chatModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View newView = view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        if (newView == null){
            if (chatModels.get(i).isSend())
                newView = layoutInflater.inflate(R.layout.message_send, null);
            else
                newView = layoutInflater.inflate(R.layout.message_receive, null);

            BubbleTextView message = newView.findViewById(R.id.text_message);
            message.setText(chatModels.get(i).getChatMessage());
        }
        return newView;
    }
}










