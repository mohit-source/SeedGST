package com.gst.pcp.best;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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
import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {

    private ImageView iv;


    String addressbh = "http://seedgst.in/getPaymentData.php";

    String s1;
String email;
    String addressfq = "http://seedgst.in/getEmail.php";
    InputStream ish = null;
    InputStream isb = null;
    String lineh=null;
    String lineb=null;
    String resulth = null;
    String resultb = null;
    String[] datah;
    String[] datab;
    String s2;
String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv = (ImageView) findViewById(R.id.iv);






        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        iv.startAnimation(myanim);

        //final Intent i = new Intent(this, MainActivity.class);
       final user user =new user(splash.this);
        // String amob=user.getMob();
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

             if(user.getMob()!="")
               {
                   getMydata();
                   newgetdata();

                   Intent i = new Intent(splash.this, homepage.class);
                   i.putExtra("name",user.getMob());
                   startActivity(i);
                   finish();
               }

               else
               {

                   Intent i = new Intent(splash.this, MainActivity.class);
                   startActivity(i);
                   finish();
                }

            }
        },3000);



    }

    private void getMydata()
    {
        try {

            final user user=new user(splash.this);
            s2=user.getMob();


            URL url = new URL(addressbh);
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            OutputStream outputStream =conn.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("s2","UTF-8")+"="+URLEncoder.encode(s2,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            ish = new BufferedInputStream(conn.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }

        try {

            BufferedReader brh = new BufferedReader(new InputStreamReader(ish));
            StringBuilder sbh=new StringBuilder();

            while ((lineh=brh.readLine())!=null){

                sbh.append(lineh + "\n");
            }

            ish.close();
            resulth = sbh.toString();
        }catch (Exception e){
            e.printStackTrace();
        }

        //Parse Json data

        try
        {
            JSONArray jah= new JSONArray(resulth);

            JSONObject joh = null;

            datah = new String[jah.length()];


            joh=jah.getJSONObject(0);
            datah[0] = joh.getString("username");
            // data[1]= jo.getString("email");
            name=datah[0];


           user user=new user(this);
            user.setName(name);




        }catch (Exception e){
            e.printStackTrace();
        }
    }




    private void newgetdata()
    {
        try {

            URL urlb = new URL(addressfq);
            HttpURLConnection con=(HttpURLConnection) urlb.openConnection();
            user user =new user(splash.this);

            s1=user.getMob();

            con.setRequestMethod("POST");
            OutputStream outputStream =con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("s1","UTF-8")+"="+URLEncoder.encode(s1,"UTF-8");
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
           user user =new user(this);
            user.setEmail(email);





        }catch (Exception e){
            e.printStackTrace();
        }

    }





}





      /*
        Thread timer=new Thread() {

            public  void run() {
                try {
                    sleep(3000);
                }catch (InterruptedException e ) {
                    e.printStackTrace();
                }
                finally {
                   // Intent i=new Intent(splash.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
                timer.start();
    }*/


