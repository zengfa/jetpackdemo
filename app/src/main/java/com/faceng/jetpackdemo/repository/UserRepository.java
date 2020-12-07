package com.faceng.jetpackdemo.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.faceng.jetpackdemo.dao.UserDao;
import com.faceng.jetpackdemo.database.UserRoomDatabase;
import com.faceng.jetpackdemo.entity.User;

import java.util.List;

public class UserRepository {

   private UserDao mUserDao;
   private LiveData<List<User>> mUsers;

   public UserRepository(Application application) {
       UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
       mUserDao = db.userDao();
       mUsers = mUserDao.getUsers();
   }

   public LiveData<List<User>> getAllUsers() {
       return mUsers;
   }


   public void insert (User user) {
       new insertAsyncTask(mUserDao).execute(user);
   }

   private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

       private UserDao mAsyncTaskDao;

       insertAsyncTask(UserDao dao) {
           mAsyncTaskDao = dao;
       }

       @Override
       protected Void doInBackground(final User... params) {
           mAsyncTaskDao.insert(params[0]);
           return null;
       }
   }
}