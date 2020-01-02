package com.gst.pcp.best;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifImageView;

public class homepage extends AppCompatActivity {

    CardView card1,card2,card3,card4,card5,card6;
    CardView pro;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    private Toolbar mToolbar;
    ViewPager viewPager;
    LinearLayout sliderDotsPanel;
    private int dotscount;
    private ImageView[] dots;
    private GifImageView g;
    TextView show;
    String homemob;
    ProgressDialog loading;



    String name,mobile,email;

    ArrayAdapter<String> adapter;
    String addressbh = "http://seedgst.in/getPaymentData.php";

    String s2;

    String addressfq = "http://seedgst.in/getPaymentData.php";
    InputStream ish = null;
    InputStream isb = null;
    String lineh=null;
    String lineb=null;
    String resulth = null;
    String resultb = null;
    String[] datah;
    String[] datab;






    String finalResult ;
    String HttpURL = "http://seedgst.in/entry.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    public static final String UserEmail = "";


    String india="india";
    String srilanka="srilanka";



    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);





        show=(TextView)findViewById(R.id.show);
        card1=(CardView)findViewById(R.id.qcard);
        card2=(CardView)findViewById(R.id.artcard);
        card3=(CardView)findViewById(R.id.faqcard);
        card4=(CardView)findViewById(R.id.gstcard);
        card5=(CardView)findViewById(R.id.chartcard);
        card6=(CardView)findViewById(R.id.updatecard);
        pro=(CardView)findViewById(R.id.pro);



        g=(GifImageView)findViewById(R.id.gif);


        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkInternetConenction()) {



                    Intent intent=new Intent(homepage.this,profile.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(homepage.this, " Please check you internet connection", Toast.LENGTH_LONG).show();

            }
        });


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {










                if(checkInternetConenction()) {


                  /*  BackgroundTry backgroundTry = new BackgroundTry(homepage.this);
                    backgroundTry.execute();

                    Intent intent=new Intent(homepage.this,QuestionForm.class);
                    startActivity(intent);
                    */
                    UserLoginFunction(india,srilanka);
                }
                else
                    Toast.makeText(homepage.this, " Please check you internet connection", Toast.LENGTH_LONG).show();

            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkInternetConenction()) {


                    Intent intent=new Intent(homepage.this,articles.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(homepage.this, " Please check you internet connection", Toast.LENGTH_LONG).show();

            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  if(checkInternetConenction()) {




                }
                else
                    Toast.makeText(homepage.this, " Please check you internet connection", Toast.LENGTH_LONG).show();*/
                Intent intent=new Intent(homepage.this,newFaq.class);
                startActivity(intent);

            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkInternetConenction()) {


                    Intent intent=new Intent(homepage.this,impdates.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(homepage.this, " Please check you internet connection", Toast.LENGTH_LONG).show();


            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkInternetConenction()) {


                    Intent intent=new Intent(homepage.this,gstchart.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(homepage.this, " Please check you internet connection", Toast.LENGTH_LONG).show();


            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkInternetConenction()) {


                    Intent intent=new Intent(homepage.this,gstupdates.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(homepage.this, " Please check you internet connection", Toast.LENGTH_LONG).show();

            }
        });
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









        g.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(homepage.this,QuestionForm.class);
        startActivity(intent);
    }
});

        viewPager = (ViewPager) findViewById(R.id.viewPager);

       sliderDotsPanel = (LinearLayout) findViewById(R.id.sliderdots);

        ViewPageAdapter viewPagerAdapter = new ViewPageAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotsPanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

        user up=new user(this);
        show.setText("Hello, "+up.getName());




    }
    //********************************************************************************************************************************



    public void UserLoginFunction(final String email, final String password){

        class UserLoginClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(homepage.this,"Please Wait...",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                    finish();

                    Intent intent = new Intent(homepage.this, QuestionForm.class);

                    //intent.putExtra(UserEmail,email);

                    startActivity(intent);

                }
                else{


                    Toast.makeText(homepage.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            protected String doInBackground(String... params) {


                hashMap.put("email",params[0]);

                hashMap.put("password",params[1]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(email,password);
    }






    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            homepage.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else if(viewPager.getCurrentItem()==2) {
                        viewPager.setCurrentItem(3);
                    }else if(viewPager.getCurrentItem()==3) {
                        viewPager.setCurrentItem(4);
                    }
                    else
                        viewPager.setCurrentItem(0);

                }
            });

        }
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
        Intent intent=new Intent(homepage.this,About.class);
        startActivity(intent);
    }
    public void home()
    {
        Intent intent=new Intent(homepage.this,homepage.class);
        startActivity(intent);
    }
    public void contact()
    {
        Intent intent=new Intent(homepage.this,About.class);
        startActivity(intent);
    }
   public void faq()
    {
        Intent intent=new Intent(homepage.this,newFaq.class);
        startActivity(intent);
    }

    public void dates()
    {
        Intent intent=new Intent(homepage.this,impdates.class);
        startActivity(intent);
    }
   public void charts()
    {
        Intent intent=new Intent(homepage.this,gstchart.class);
        startActivity(intent);
    }
    public void profile()
    {
        Intent intent=new Intent(homepage.this,profile.class);
        startActivity(intent);
    }

    public void returns()
    {
        Intent intent=new Intent(homepage.this,gstreturn.class);
        startActivity(intent);
    }


    public void works()
    {
        Intent intent=new Intent(homepage.this,HAW.class);
        startActivity(intent);
    }

    public void terms()
    {
        Intent intent=new Intent(homepage.this,TNC.class);
        startActivity(intent);
    }
    public void signout()
    {

        new AlertDialog.Builder(homepage.this)
                .setIcon(android.R.drawable.ic_lock_lock)
                .setTitle("Sign out")
                .setMessage("Do You want to Sign out ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        new user(homepage.this).removeUser();

                        Intent intent=new Intent(homepage.this,MainActivity.class);
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
    public void onBackPressed(){


        super.onBackPressed();

        Intent i=new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();

    }









}
