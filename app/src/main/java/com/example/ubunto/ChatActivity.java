package com.example.ubunto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.ubunto.Adapter.MessageAdapter;
import com.example.ubunto.Model.Message;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    Socket socket;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MessageAdapter messageAdapter;
    ArrayList<Message> messages;
    EditText EntreMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messages=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerView);
        EntreMessage = findViewById(R.id.EntreMessage);
        layoutManager =new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        messageAdapter =new MessageAdapter(messages ,this );
        recyclerView.setAdapter(messageAdapter);
        recyclerView.setLayoutManager(layoutManager);
        try {
            socket=IO.socket("http://10.0.0.43:3000");
            socket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        socket.on("DataFromMOdel", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
            String solution=(String) args[0];
            Message message=new Message();
            message.setUser(2);
            message.setMessage(solution);
            messages.add(message);
            messageAdapter.notifyItemInserted(messages.size()-1);
            }
        });
    }

    public void SendMessage(View view) {
        socket.emit("DataFromUser",EntreMessage.getText().toString(),1);
        Message message=new Message();
        message.setMessage(EntreMessage.getText().toString());
        message.setUser(1);
        messages.add(message);
        messageAdapter.notifyItemInserted(messages.size()-1);
        EntreMessage.setText("");
    }
}
