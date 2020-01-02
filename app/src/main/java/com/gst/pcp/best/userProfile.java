package com.gst.pcp.best;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by PCP on 31-12-2017.
 */

public class userProfile {

    Context contextb;
    SharedPreferences sharedPreferencesb;

    public void removeUserProfile()
    {
        sharedPreferencesb.edit().clear().commit();
    }


    public String getUserName() {
        username=sharedPreferencesb.getString("profileusernamedata","");
        return username;
    }
    public String getUserEmail() {
        useremail=sharedPreferencesb.getString("profileuseremaildata","");
        return useremail;
    }

    public void setUserName(String username) {
        this.username =username;
        sharedPreferencesb.edit().putString("profileusernamedata",username).commit();
    }

    public void setUserEmail(String useremail)
    {
        this.useremail=useremail;
        sharedPreferencesb.edit().putString("profileuseremaildata",useremail).commit();
    }

    private String username;
    private String useremail;

    public userProfile(Context contextb)
    {
        this.contextb=contextb;
        sharedPreferencesb=contextb.getSharedPreferences("userinfo",Context.MODE_PRIVATE);

    }
}