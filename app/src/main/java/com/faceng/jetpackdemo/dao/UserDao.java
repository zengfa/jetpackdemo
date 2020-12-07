package com.faceng.jetpackdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.faceng.jetpackdemo.entity.User;

import java.util.List;

@Dao
public interface UserDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   void insert(User user);

   @Query("DELETE FROM user_table")
   void deleteAll();

   @Query("SELECT * from user_table")
   LiveData<List<User>> getUsers();
}