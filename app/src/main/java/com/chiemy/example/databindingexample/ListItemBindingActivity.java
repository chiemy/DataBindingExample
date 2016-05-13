package com.chiemy.example.databindingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chiemy.example.databindingexample.bean.User;
import com.chiemy.example.databindingexample.databinding.ListItemBinding;

import java.util.Random;

public class ListItemBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item_binding);
        setTitle("ListItemBinding");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserListAdapter());
    }

    private class UserListAdapter extends RecyclerView.Adapter<UserViewHolder>{

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new UserViewHolder(getLayoutInflater().inflate(R.layout.list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(UserViewHolder holder, int position) {
            User user = new User();
            user.setFirstName("chiemy " + position);
            user.setLastName("luo");
            user.setIsFriend(new Random().nextBoolean());
            holder.bind(user);
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    private class UserViewHolder extends RecyclerView.ViewHolder{
        private ListItemBinding binding;
        public UserViewHolder(View itemView) {
            super(itemView);
            binding = ListItemBinding.bind(itemView);
        }

        public void bind(User user){
            binding.setUser(user);
            binding.setHandler(ListItemBindingActivity.this);
        }
    }

    public void onClickFriend(View view){
        String userName = getUserName(view);
        Toast.makeText(this, userName + " is Friend", Toast.LENGTH_SHORT).show();
    }

    public void onClickEnemy(View view){
        String userName = getUserName(view);
        Toast.makeText(this, userName + " is Enemy", Toast.LENGTH_SHORT).show();
    }

    private String getUserName(View view){
        Object tag = view.getTag();
        String userName = "";
        if (tag instanceof User){
            User user = (User) tag;
            userName  = user.getFirstName();
        }
        return userName;
    }
}
