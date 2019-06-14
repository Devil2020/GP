package com.example.ubunto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class ChatActivity extends AppCompatActivity {
    Socket socket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        try {
            socket=IO.socket("");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
