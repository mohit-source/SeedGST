package com.gst.pcp.best;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

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
import java.util.HashMap;

public class MainActivity extends Activity {

    EditText edmob,edpass;
    ImageButton ibsignin;
    ImageView ivsignup;


String smob,spass;


    String addressbh = "http://seedgst.in/getPaymentData.php";

    String s2,s1;
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
    String name;


    String finalResult ;
    String HttpURL = "http://seedgst.in/UserLogin.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    public static final String UserEmail = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        edmob=(EditText)findViewById(R.id.phoneid);
        edpass=(EditText)findViewById(R.id.passid);
        ibsignin=(ImageButton)findViewById(R.id.signinid);
        ivsignup=(ImageView)findViewById(R.id.signupid);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));


        ivsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this,PhoneAuthActivity.class);
                startActivity(intent);

            }
        });


        ibsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OnLogin();

            }
        });



    }
    public void OnLogin()
    {

        if(checkInternetConenction()) {
            GetData();
            if (!validate()) {
                Toast.makeText(this, "Insert aboove detatils..", Toast.LENGTH_SHORT).show();
            } else {


                //getMydata();
                //newgetdata();
              //  String typeb = "login";
                /*BackgroundLogin backgroundLogin = new BackgroundLogin(this);
                backgroundLogin.execute(typeb, smob, spass);
                */
                progressDialog = ProgressDialog.show(MainActivity.this,"Signing In...",null,false,false);
                UserLoginFunction(smob, spass);
                user user=new user(MainActivity.this);
                user.setMob(smob);
                user.setPass(spass);

            }
        }
        else
            Toast.makeText(MainActivity.this, " Please check you internet connection", Toast.LENGTH_LONG).show();

    }
    public void GetData()
    {
         smob = edmob.getText().toString();
         spass = edpass.getText().toString();

    }

    public boolean validate()
    {
        boolean valid=true;

        if(smob.isEmpty()||smob.length()!=10) {
            edmob.setError("Please Enter mobile no.!");
            valid=false;
        }
        if(spass.isEmpty()||spass.length()>32)
        {
            edpass.setError("Please Enter a password!");
            valid=false;
        }

        return valid;
    }

    public void UserLoginFunction(final String email, final String password){

        class UserLoginClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(MainActivity.this,"Signing In...",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                    finish();

                    Intent intent = new Intent(MainActivity.this, homepage.class);

                    //intent.putExtra(UserEmail,email);

                    startActivity(intent);

                }
                else{

                    user user=new user(MainActivity.this);
                    user.removeUser();
                    Toast.makeText(MainActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            protected String doInBackground(String... params) {

                getMydata();
                newgetdata();

                hashMap.put("email",params[0]);

                hashMap.put("password",params[1]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(email,password);
    }


    private boolean checkInternetConenction()
    {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec
                =(ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED )
        {

            return true;
        }
        else if (
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED  )
        {

            return false;
        }
        return false;
    }



    private void getMydata()
    {
        try {

            final user user=new user(MainActivity.this);
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
            user user =new user(MainActivity.this);

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


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        super.onBackPressed();

        Intent i=new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();

    }
}

