package com.example.post_app;

import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    CircleImageView profileImage;
    ImageView postImage,likeImage,commentsImage,commentsSend;
    TextView username,timeAgo,postDesc,likeCounter,commentsCount;
    EditText inputComments;
    public static RecyclerView recyclerView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        profileImage = itemView.findViewById(R.id.profileImagePost);
        postImage = itemView.findViewById(R.id.postImage);
        username = itemView.findViewById(R.id.profileUsernamePost);
        timeAgo = itemView.findViewById(R.id.timeAgo);
        postDesc = itemView.findViewById(R.id.postDesc);
        likeImage = itemView.findViewById(R.id.likeImage);
        commentsImage = itemView.findViewById(R.id.CommentImage);
        likeCounter = itemView.findViewById(R.id.likeCount);
        commentsSend = itemView.findViewById(R.id.sendComment);
        commentsCount = itemView.findViewById(R.id.commentsCounter);
        inputComments = itemView.findViewById(R.id.inputComments);
        recyclerView = itemView.findViewById(R.id.recyclerViewComments);
    }

    public void countLikes(String postKey, String uid, DatabaseReference likeref) {
        likeref.child(postKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int totalLikes = (int)snapshot.getChildrenCount();
                    likeCounter.setText(totalLikes+"");
                }else{
                    likeCounter.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        likeref.child(postKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    likeImage.setColorFilter(Color.GREEN);
                }else{
                    likeImage.setColorFilter(Color.GRAY);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void countComments(String postKey, String uid, DatabaseReference commentRef) {
        commentRef.child(postKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int totalComments = (int)snapshot.getChildrenCount();
                    commentsCount.setText(totalComments+"");
                }else{
                    commentsCount.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
