package com.example.ubunto.View.SplachScreenFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ubunto.R;


public class DetailFragmentSplachScreen extends Fragment {
    public DetailFragmentSplachScreen(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_fragment_splach_screen, container, false);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
   }

    @Override
    public void onDetach() {
        super.onDetach();
      }
}
