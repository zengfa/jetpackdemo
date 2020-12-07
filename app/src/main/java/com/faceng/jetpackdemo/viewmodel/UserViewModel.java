package com.faceng.jetpackdemo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.faceng.jetpackdemo.entity.User;
import com.faceng.jetpackdemo.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

   private UserRepository mRepository;

   private LiveData<List<User>> mAllUser;

   public UserViewModel(Application application) {
       super(application);
       mRepository = new UserRepository(application);
       mAllUser = mRepository.getAllUsers();
   }

   public LiveData<List<User>> getAllUsers() { return mAllUser; }

   public void insert(User user) { mRepository.insert(user); }
}