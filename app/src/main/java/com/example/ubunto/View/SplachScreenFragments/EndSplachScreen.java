package com.example.ubunto.View.SplachScreenFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ubunto.ChatActivity;
import com.example.ubunto.R;

public class EndSplachScreen extends Fragment {
Context context;
    public EndSplachScreen() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end_splach_screen, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    this.context=context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void GoToActivity(View view) {
        Intent intent=new Intent(context, ChatActivity.class);
        startActivity(intent);
    }
}
