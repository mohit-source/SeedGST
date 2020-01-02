package com.gst.pcp.best;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by PCP on 16-01-2018.
 */

public class navigation_header extends AppCompatActivity {

    TextView pno;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_header);

        pno=(TextView)findViewById(R.id.phonenumber);


        user user=new user(navigation_header.this);
         s1=user.getMob();
        pno.setText(s1);

    }

}
