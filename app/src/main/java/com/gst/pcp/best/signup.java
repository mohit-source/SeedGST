package com.gst.pcp.best;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import pl.droidsonroids.gif.GifImageView;

public class signup extends Activity {

    EditText eduser, edmob, edpass, edmail;
    ImageButton ibsignup;
    ImageView ivsignin;
     String suser, semail, smob, spass;
TextView tvmob;


    GifImageView g;



    String finalResult ;
    String HttpURL = "https://seedgst.in/UserRegistration.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_signup);


        eduser = (EditText) findViewById(R.id.useridb);
       // edmob = (EditText) findViewById(R.id.phoneidb);
        tvmob=(TextView) findViewById(R.id.tvmob);
        edpass = (EditText) findViewById(R.id.passidb);
        ivsignin = (ImageView) findViewById(R.id.exsignb);
        ibsignup = (ImageButton) findViewById(R.id.signupidb);
        edmail = (EditText) findViewById(R.id.emailidb);


        Intent i=getIntent();
        smob=i.getStringExtra("passingNumber");
        tvmob.setText(smob);

        ivsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ibsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OnReg();
               // GetData();
               // InsertData(suser, semail, smob, spass);
            }
        });

    }


    private void sendEmail() {
        //Getting content for email
        // String email = editTextEmail.getText().toString().trim();

        user user =new user(signup.this);


        String email = " siddhesh@seedgst.in";//ksolution to siddhesh
        //  String subject = editTextSubject.getText().toString().trim();
        String subject = "New User Registered to Sangam Property Cares.";
        //  String message = editTextMessage.getText().toString().trim();

        String message = "Dear Client," + "\n"+"New user registration in Seed GST has been done successfully."+"\n\n"+
                "Please find customer details as follows :  \n\n"+
                "Name :"+eduser.getText().toString()+"\n"+
                "Mobile No:"+tvmob.getText().toString()+"\n"+
                "Email :"+edmail.getText().toString()+"\n\n\n"+
                "Thank You and Regards,"+"\n"+
                "Team K Solutions."+"\n"+
                "www.ksolution.in"+"\n";


        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);
        //Executing sendmail to send email
        sm.execute();
    }

    private void sendEmailtoUser() {
        //Getting content for email
        // String email = editTextEmail.getText().toString().trim();

        user user =new user(signup.this);


        String email =edmail.getText().toString();
        //  String subject = editTextSubject.getText().toString().trim();
        String subject = "Wecome to Seed GST.";
        //  String message = editTextMessage.getText().toString().trim();

        String message = "Hi " +eduser.getText().toString()+","+"\n"+"Thank you for signing up with Seed GST."+"\n\n"+
                "Our Team is here to take care of your GST related issues. In case you need some help, please feel free to mail us at info@seedgst.in and we'll be with you right away.  \n"+
                "\n\n\n\n"+

                "Thank You,"+"\n"+

                "Team Seed GST,"+"\n"+"Nurturing Solutions..."+"\n"+"www.seedgst.in";


        //Creating SendMail object
        SendMailAnother sm = new SendMailAnother(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }




    public void OnReg() {


        if(checkInternetConenction()) {


            GetData();
            if (!validate()) {
                Toast.makeText(this, "Insert above details..", Toast.LENGTH_SHORT).show();
            } else {
                /*String type = "register";
                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                backgroundWorker.execute(type, suser, semail, smob, spass);
                */

                UserRegisterFunction(suser,semail,smob,spass);
                sendEmailtoUser();
                sendEmail();
                Intent i = new Intent(signup.this, MainActivity.class);

                startActivity(i);
            }
        }
        else
            Toast.makeText(signup.this, " Please check you internet connection", Toast.LENGTH_LONG).show();



    }
    public void GetData() {

        suser = eduser.getText().toString();
        semail = edmail.getText().toString();
       // smob = edmob.getText().toString();

        spass = edpass.getText().toString();

    }


    public void UserRegisterFunction(final String username, final String email, final String mobile, final String password){

        class UserRegisterFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(signup.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(signup.this,httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("username",params[0]);

                hashMap.put("email",params[1]);

                hashMap.put("mobile",params[2]);

                hashMap.put("password",params[3]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();

        userRegisterFunctionClass.execute(username,email,mobile,password);
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
            //Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            return true;
        }
        else if (
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED  )
        {
            //Toast.makeText(this, " Not Connected ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }

    public boolean validate()
    {
        boolean valid=true;
        if(suser.isEmpty()||suser.length()>32)
        {
            eduser.setError("Please Enter a  name!!");
            valid=false;
        }
        if(semail.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(semail).matches())
        {
            edmail.setError("Please Enter a valid Email Id !");
            valid=false;
        }
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


}











 /*   public void OnReg()
    {
       String suser = eduser.getText().toString();
        String semail = edmail.getText().toString();
        String smob = edmob.getText().toString();
        String spass = edpass.getText().toString();


            String type = "register";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, suser, semail, smob, spass);




    }

*/

/*
    public void GetData() {

        suser = eduser.getText().toString();
        semail = edmail.getText().toString();
        smob = edmob.getText().toString();
        spass = edpass.getText().toString();

    }

    public void InsertData(final String username, final String email, final String mobile, final String password) {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String NameHolder = username;
                String EmailHolder = email;
                String MobileHolder = mobile;
                String PasswordHolder = password;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("username", NameHolder));
                nameValuePairs.add(new BasicNameValuePair("email", EmailHolder));
                nameValuePairs.add(new BasicNameValuePair("mobile", MobileHolder));
                nameValuePairs.add(new BasicNameValuePair("password", PasswordHolder));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                Toast.makeText(signup.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(username, email, mobile, password);
    }

*/
