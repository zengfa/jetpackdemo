package com.faceng.jetpackdemo.rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.faceng.jetpackdemo.R;
import com.faceng.jetpackdemo.entity.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

   class UserViewHolder extends RecyclerView.ViewHolder {
       private final TextView tvUser;

       private UserViewHolder(View itemView) {
           super(itemView);
           tvUser = itemView.findViewById(R.id.textView);
       }
   }

   private final LayoutInflater mInflater;
   private List<User> mUsers;

   public UserListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

   @Override
   public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
       return new UserViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(UserViewHolder holder, int position) {
       if (mUsers != null) {
           User current = mUsers.get(position);
           holder.tvUser.setText(current.getUser());
       } else {
           // Covers the case of data not being ready yet.
           holder.tvUser.setText("No data");
       }
   }

   public void setUsers(List<User> users){
       mUsers = users;
       notifyDataSetChanged();
   }

   @Override
   public int getItemCount() {
       if (mUsers != null)
           return mUsers.size();
       else return 0;
   }
}