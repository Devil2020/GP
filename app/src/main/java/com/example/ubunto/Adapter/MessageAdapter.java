package com.example.ubunto.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ubunto.Model.Message;
import com.example.ubunto.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    ArrayList<Message> Messeges;
    Context context;
    public MessageAdapter(ArrayList<Message> Messages , Context context){
        this.context=context;
        this.Messeges = Messages;
    }
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.message_item_shape,viewGroup,false );
       return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int i) {

        if(Messeges.get(i).getUser()==1){
            Picasso.with(context).load(R.drawable.man).into(messageViewHolder.User);
            messageViewHolder.Root.setBackground(context.getResources().getDrawable(R.drawable.orange_roundable_right));

        }
        else {
            Picasso.with(context).load(R.drawable.chatbot).into(messageViewHolder.User);
            messageViewHolder.Root.setBackground(context.getResources().getDrawable(R.drawable.gray_roundable_left));

        }
        messageViewHolder.Message.setText(Messeges.get(i).getMessage());
    }

    @Override
    public int getItemCount() {
        return Messeges.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{
        ImageView User ;
        TextView Message;
        LinearLayout Root;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            User=itemView.findViewById(R.id.Image);
            Message =itemView.findViewById(R.id.MessageItem);
            Root=itemView.findViewById(R.id.LayoutMessageItem);
        }
    }
}
