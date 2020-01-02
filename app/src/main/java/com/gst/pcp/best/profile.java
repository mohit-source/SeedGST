package com.gst.pcp.best;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.InputStream;

public class profile extends AppCompatActivity {

    TextView fname, pnumber, emailAddress;

    String addressb = "http://seedgst.in/getPaymentData.php";

    String s2;

    String addressfq = "http://seedgst.in/getPaymentData.php";
    InputStream is = null;
    InputStream isb = null;
    String line=null;
    String lineb=null;
    String result = null;
    String resultb = null;
    String[] data;
    String[] datab;
    String name,mobile,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        fname        = (TextView) findViewById(R.id.username);
        pnumber      = (TextView)findViewById(R.id.mobno);
        emailAddress = (TextView)findViewById(R.id.emailn);



        final user user=new user(profile.this);
        s2=user.getMob();
        pnumber.setText("+91"+s2);
        emailAddress.setText(user.getEmail());
        user us=new user(this);
        fname.setText(us.getName());


    }






}
