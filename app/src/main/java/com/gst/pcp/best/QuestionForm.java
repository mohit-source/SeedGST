package com.gst.pcp.best;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.payu.india.Model.PaymentParams;
import com.payu.india.Model.PayuConfig;
import com.payu.india.Payu.Payu;

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
import java.text.DateFormat;
import java.util.Date;

import pl.droidsonroids.gif.GifImageView;

public class QuestionForm extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    private Toolbar mToolbar;
    Button sendbtn;
    String question,nmob,s2,tmob,tpass;
    EditText edquest;
    ProgressBar progressBar;
    TextView tv;
    String boolq="0";
    private GifImageView g;
    ListView questlist;
    ArrayAdapter<String> adapter;
    String addressb = "http://seedgst.in/fetch_answer.php";
    String addressfq = "http://seedgst.in/fetch_fq.php";
    InputStream is = null;
    InputStream isb = null;
    String line=null;
    String lineb=null;
    String result = null;
    String resultb = null;
    String[] data;
    String[] datab;
    String newquestion;


    private String merchantKey,useCredentials;
    private PaymentParams mPaymentParams;
    private PayuConfig payuConfig;


    Context context;
    String status;



    //declaring strings

    String sendEmail;
    String sendSubject;
    String sendMessage;

    //Send button
    private Button buttonSend;

    ProgressBar simpleProgressBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_form);


        Payu.setInstance(this);




        g=(GifImageView)findViewById(R.id.gif);
        sendbtn=(Button)findViewById(R.id.sendbtn);
        edquest=(EditText)findViewById(R.id.edquest);
        tv=(TextView)findViewById(R.id.tvf);

        questlist=(ListView)findViewById(R.id.questlist);
        //Allow network in main thread
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        final user user=new user(QuestionForm.this);
        nmob=user.getMob();

        s2=nmob;
        //retrieve
        getdata();
        newgetdata();
        g=(GifImageView)findViewById(R.id.gif);










        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuestionForm.this,QuestionForm.class);
                startActivity(intent);
            }
        });


        //adapter
        if(data==null)
        {
            Toast.makeText(this, "Welcome to Seed GST...", Toast.LENGTH_SHORT).show();
        }

        else if(data!=null) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
            {
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    /// Get the Item from ListView

                    View view = super.getView(position, convertView, parent);

                    view.setBackgroundDrawable(ContextCompat.getDrawable(QuestionForm.this,R.drawable.listview_item_border));


                    TextView tv = (TextView) view.findViewById(android.R.id.text1);
                /*
                    setShadowLayer(float radius, float dx, float dy, int shadowColor)
                        This draws a shadow layer below the main layer,
                        with the specified offset and color, and blur radius.
                 */
                    // Set the shadow of ListView each item
                    tv.setShadowLayer(1.7f,-2,2, Color.WHITE);


                    // Return the view
                    return view;
                }
            };


            questlist.setAdapter(adapter);

    }






        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.about)
                {
                        about();
                }
                if(item.getItemId()==R.id.home)
                {
                    home();
                }
                if(item.getItemId()==R.id.profile)
                {
                    profile();
                }
                if(item.getItemId()==R.id.contact)
                {
                    contact();
                }
                if(item.getItemId()==R.id.faq)
                {
                    faq();
                }
                if(item.getItemId()==R.id.gstimpdate)
                {
                    dates();
                }
                if(item.getItemId()==R.id.gstchrt)
                {
                    charts();
                }

                if(item.getItemId()==R.id.gstretrn)
                {
                    returns();
                }


                if(item.getItemId()==R.id.howwork)
                {
                    works();
                }

                if(item.getItemId()==R.id.terms)
                {
                    terms();
                }
                if(item.getItemId()==R.id.signout)
                {
                    signout();
                }

                return false;
            }
        });






    }
    //********************************************************************************************************************************









    private void sendEmail() {
        //Getting content for email
        // String email = editTextEmail.getText().toString().trim();
        String email = "question@seedgst.in";
        //  String subject = editTextSubject.getText().toString().trim();
        String subject = "Incoming Question from SeedGST";
        //  String message = editTextMessage.getText().toString().trim();
        user user =new user(this);
        //user.getMob();
        String message = "You have received a message from "+user.getName()+"\n"+
                          "Question : \n"+
                          newquestion+"\n\n\n"+
                          "Client's Details :\n\n"+
                            "Name :  "+user.getName()+"\n"+"Email :  "+user.getEmail()+"\n"+
                            "Mobile No. :  "+user.getMob();

        ;
        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }














    private void getdata()
    {



        try {

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

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data[i] = jo.getString("qna");

            }




        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void OnQuestion()
    {
        if(checkInternetConenction()) {
            GetData();
            if (!validate()) {
                Toast.makeText(this, "Please enter a meassage....", Toast.LENGTH_SHORT).show();
            } else {
                String type = "quest";
                BackgroundQuestion backgroundQuestion = new BackgroundQuestion(this);
                backgroundQuestion.execute(type, newquestion, nmob, boolq);
                edquest.setText("");


            }
        }
        else
            Toast.makeText(QuestionForm.this, " Please check you internet connection", Toast.LENGTH_LONG).show();
    }





    public void GetData()
    {
        String date = DateFormat.getDateTimeInstance()
                .format(new Date());
        question = edquest.getText().toString();
        newquestion=date+"\n\nQ : "+question+"\n";
    }


    private void newgetdata()
    {
        try {

            URL urlb = new URL(addressfq);
            HttpURLConnection con=(HttpURLConnection) urlb.openConnection();
            user user =new user(QuestionForm.this);

            tmob=user.getMob();
            tpass=user.getPass();
            con.setRequestMethod("POST");
            OutputStream outputStream =con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("tmob","UTF-8")+"="+URLEncoder.encode(tmob,"UTF-8")
                    +"&"+URLEncoder.encode("tpass","UTF-8")+"="+URLEncoder.encode(tpass,"UTF-8");
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
                datab[i] = job.getString("freequestatus");

            }

            tv.setText("Ask Your Questions Here!");

            sendbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    newgetdata();

                    if(datab[0].equals("0"))
                    {


                        String types="status";
                        user user =new user (QuestionForm.this);
                        tmob=user.getMob();
                        tpass=user.getPass();
                        BackgroundStatus backgroundStatus=new BackgroundStatus(QuestionForm.this);
                        backgroundStatus.execute(types,tmob,tpass);
                        sendbtn.setEnabled(false);
                        OnQuestion();

                        sendEmail();
                        getdata();

                       Intent i= getIntent();
                        startActivity(i);
                        sendbtn.setEnabled(true);

                    }
                    else
                    {

                        if(checkInternetConenction()) {

                          //  Toast.makeText(QuestionForm.this, "This is for paid customers!", Toast.LENGTH_SHORT).show();


                            Intent intent=new Intent(QuestionForm.this,payment.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(QuestionForm.this, " Please check you internet connection", Toast.LENGTH_LONG).show();




                    }

                }
            });




        }catch (Exception e){
            e.printStackTrace();
        }

    }











    public boolean validate()
    {
        boolean valid=true;

        if(question.isEmpty()) {

            valid=false;
        }

        return valid;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void about()
    {
        Intent intent=new Intent(QuestionForm.this,About.class);
        startActivity(intent);
    }
    public void profile()
    {
        Intent intent=new Intent(QuestionForm.this,profile.class);
        startActivity(intent);
    }
    public void home()
    {
        Intent intent=new Intent(QuestionForm.this,homepage.class);
        startActivity(intent);
    }
    public void contact()
    {
        Intent intent=new Intent(QuestionForm.this,About.class);
        startActivity(intent);
    }
    public void faq()
    {
        Intent intent=new Intent(QuestionForm.this,newFaq.class);
        startActivity(intent);
    }

    public void dates()
    {
        Intent intent=new Intent(QuestionForm.this,impdates.class);
        startActivity(intent);
    }
    public void charts()
    {
        Intent intent=new Intent(QuestionForm.this,gstchart.class);
        startActivity(intent);
    }

    public void returns()
    {
        Intent intent=new Intent(QuestionForm.this,gstreturn.class);
        startActivity(intent);
    }


    public void works()
    {
        Intent intent=new Intent(QuestionForm.this,HAW.class);
        startActivity(intent);
    }

    public void terms()
    {
        Intent intent=new Intent(QuestionForm.this,TNC.class);
        startActivity(intent);
    }
    public void signout()
    {

        new AlertDialog.Builder(QuestionForm.this)
                .setIcon(android.R.drawable.ic_lock_lock)
                .setTitle("Sign out")
                .setMessage("Do You want to Sign out ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        new user(QuestionForm.this).removeUser();

                        Intent intent=new Intent(QuestionForm.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(QuestionForm.this,homepage.class);
        startActivity(intent);
        finish();
    }

}


