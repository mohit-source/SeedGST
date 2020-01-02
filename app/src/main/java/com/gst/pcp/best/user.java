package com.gst.pcp.best;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by PCP on 31-12-2017.
 */

public class user {

    Context context;
    SharedPreferences sharedPreferences;

    public void removeUser()
    {
        sharedPreferences.edit().clear().commit();
    }

    public String getMob() {
        mob=sharedPreferences.getString("userdata","");
        return mob;
    }
    public String getName() {
        name=sharedPreferences.getString("usernamedata","");
        return name;
    }
    public String getEmail() {
        email=sharedPreferences.getString("useremaildata","");
        return email;
    }
    public String getPass(){

        pass=sharedPreferences.getString("passdata","");
        return  pass;
    }

    public void setMob(String mob) {
        this.mob =mob;
        sharedPreferences.edit().putString("userdata",mob).commit();
    }
    public void setName(String name) {
        this.name =name;
        sharedPreferences.edit().putString("usernamedata",name).commit();
    }
    public void setPass(String pass)
    {
        this.pass=pass;
        sharedPreferences.edit().putString("passdata",pass).commit();
    }
    public void setEmail(String email)
    {
        this.email=email;
        sharedPreferences.edit().putString("useremaildata",email).commit();
    }
    private String mob;
    private String pass;
    private String name;
    private String email;

    public user(Context context)
    {
            this.context=context;
            sharedPreferences=context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);

    }
}