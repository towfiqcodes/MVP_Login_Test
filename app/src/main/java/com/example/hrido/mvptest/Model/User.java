package com.example.hrido.mvptest.Model;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.hrido.mvptest.Controller.IUser;

public class User implements IUser {
    String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        //0 check email is empty
        //1 check email is matches pattern
        //2 check password lenght>6

        if(TextUtils.isEmpty(getEmail()))
            return 0;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if(getPassword().length()<=6)
            return 2;
        else
            return -1;
    }
}
