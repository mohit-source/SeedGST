package com.gst.pcp.best;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class payment extends AppCompatActivity {

    TextView fname, pnumber, emailAddress;
    TextView rechargeAmt;
    Button Paynow,backbtn;
    String name,mobile,email;

    ArrayAdapter<String> adapter;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        fname        = (TextView) findViewById(R.id.fname);
        pnumber      = (TextView)findViewById(R.id.pnumber);
        emailAddress = (TextView)findViewById(R.id.emailAddress);
        rechargeAmt  = (TextView) findViewById(R.id.rechargeAmt);
        Paynow       = (Button)findViewById(R.id.Paynow);
backbtn=(Button)findViewById(R.id.backbtn);

        getdata();
        newgetdata();

        final user user=new user(payment.this);
        s2=user.getMob();
        pnumber.setText(s2);

        Paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getFname = fname.getText().toString().trim();
                String getPhone = pnumber.getText().toString().trim();
               String getEmail = emailAddress.getText().toString().trim();
               // String Email = "this is email";
                String getAmt   = "100";//rechargeAmt.getText().toString().trim();

                Intent intent = new Intent(payment.this, PayMentGateWay.class);
                intent.putExtra("FIRST_NAME",getFname);
                intent.putExtra("PHONE_NUMBER",s2);
                intent.putExtra("EMAIL_ADDRESS",getEmail);
                intent.putExtra("RECHARGE_AMT",getAmt);
                startActivity(intent);

            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(payment.this,QuestionForm.class);
                startActivity(i);
            }
        });

    }



    private void getdata()
    {
        try {

            final user user=new user(payment.this);
            s2=user.getMob();


            URL url = new URL(addressb);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            OutputStream outputStream =con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("s2","UTF-8")+"="+URLEncoder.encode(s2,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            is = new BufferedInputStream(con.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();

            while ((line=br.readLine())!=null){

                sb.append(line + "\n");
            }

            is.close();
            result = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }

        //Parse Json data

        try
        {
            JSONArray ja = new JSONArray(result);

            JSONObject jo = null;

            data = new String[ja.length()];


                jo=ja.getJSONObject(0);
                data[0] = jo.getString("username");
               // data[1]= jo.getString("email");
            name=data[0];

            fname.setText(name);


        }catch (Exception e){
            e.printStackTrace();
        }
    }







    private void newgetdata()
    {
        try {

            URL urlb = new URL(addressfq);
            HttpURLConnection con=(HttpURLConnection) urlb.openConnection();
            user user =new user(payment.this);

            s2=user.getMob();

            con.setRequestMethod("POST");
            OutputStream outputStream =con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("s2","UTF-8")+"="+URLEncoder.encode(s2,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            isb = new BufferedInputStream(con.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }

        try {

            BufferedReader brb = new BufferedReader(new InputStreamReader(isb));
            StringBuilder sbb=new StringBuilder();

            while ((lineb=brb.readLine())!=null){

                sbb.append(lineb + "\n");
            }

            isb.close();
            resultb = sbb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }

        //Parse Json data

        try
        {
            JSONArray jab = new JSONArray(resultb);

            JSONObject job = null;

            datab = new String[jab.length()];

            for(int i=0;i<jab.length();i++)
            {
                job=jab.getJSONObject(i);
                datab[0] = job.getString("email");

            }

            email=datab[0];
            emailAddress.setText(email);




        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
