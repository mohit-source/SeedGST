package com.gst.pcp.best;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import pl.droidsonroids.gif.GifImageView;

public class impdates extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    private Toolbar mToolbar;

    private GifImageView g;

    private Button knowdate;

    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    TextView tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8;
    JSONObject json = null;
    String str = "";
    HttpResponse response;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impdates);

        t1=(TextView)findViewById(R.id.gstrbone);
        t2=(TextView)findViewById(R.id.gstrbtwo);
        t3=(TextView)findViewById(R.id.gstrbthree);
        t4=(TextView)findViewById(R.id.gstrbfour);
        t5=(TextView)findViewById(R.id.gstrbfive);
        t6=(TextView)findViewById(R.id.gstrbsix);
        t7=(TextView)findViewById(R.id.gstrbseven);
        t8=(TextView)findViewById(R.id.gstrbeight);

        tt1=(TextView)findViewById(R.id.dateone);
        tt2=(TextView)findViewById(R.id.datetwo);
        tt3=(TextView)findViewById(R.id.datethree);
        tt4=(TextView)findViewById(R.id.datefour);
        tt5=(TextView)findViewById(R.id.datefive);
        tt6=(TextView)findViewById(R.id.datesix);
        tt7=(TextView)findViewById(R.id.dateseven);
        tt8=(TextView)findViewById(R.id.dateeight);

        g=(GifImageView)findViewById(R.id.gif);

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(impdates.this,QuestionForm.class);
                startActivity(intent);
            }
        });

        knowdate=(Button)findViewById(R.id.knowdates);

        knowdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url= Uri.parse("https://www.gst.gov.in/");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawerLayouttt);
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

                if(item.getItemId()==R.id.profile)
                {
                    profile();
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
        new GetTextViewData(context).execute();
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
        Intent intent=new Intent(impdates.this,About.class);
        startActivity(intent);
    }
    public void home()
    {
        Intent intent=new Intent(impdates.this,homepage.class);
        startActivity(intent);
    }
    public void contact()
    {
        Intent intent=new Intent(impdates.this,About.class);
        startActivity(intent);
    }
    public void faq()
    {
        Intent intent=new Intent(impdates.this,newFaq.class);
        startActivity(intent);
    }

    public void dates()
    {
        Intent intent=new Intent(impdates.this,impdates.class);
        startActivity(intent);
    }
    public void charts() {
        Intent intent = new Intent(impdates.this, gstchart.class);
        startActivity(intent);
    }

  public void returns()
    {
        Intent intent=new Intent(impdates.this,gstreturn.class);
        startActivity(intent);
    }
   public void formats()
    {
        Intent intent=new Intent(impdates.this,gif.class);
        startActivity(intent);
    }

    public void works()
    {
        Intent intent=new Intent(impdates.this,HAW.class);
        startActivity(intent);
    }

    public void terms()
    {
        Intent intent=new Intent(impdates.this,TNC.class);
        startActivity(intent);
    }
    public void profile()
    {
        Intent intent=new Intent(impdates.this,profile.class);
        startActivity(intent);
    }
    public void signout()
    {
        new AlertDialog.Builder(impdates.this)
                .setIcon(android.R.drawable.ic_lock_lock)
                .setTitle("Sign out")
                .setMessage("Do You want to Sign out ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        new user(impdates.this).removeUser();

                        Intent intent=new Intent(impdates.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }



    private class GetTextViewData extends AsyncTask<Void, Void, Void>
    {
        public Context context;


        public GetTextViewData(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {

            HttpClient myClient = new DefaultHttpClient();
            HttpPost myConnection = new HttpPost("http://seedgst.in/fetch_dates.php");

            try {
                response = myClient.execute(myConnection);
                str = EntityUtils.toString(response.getEntity(), "UTF-8");

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            try{
                JSONArray jArray = new JSONArray(str);
                json = jArray.getJSONObject(0);



            } catch ( JSONException e) {
                e.printStackTrace();
            }

            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Void result)
        {
            try {
                t1.setText(json.getString("gstrbone"));
                t2.setText(json.getString("gstrbtwo"));
                t3.setText(json.getString("gstrbthree"));
                t4.setText(json.getString("gstrbfour"));
                t5.setText(json.getString("gstrbfive"));
                t6.setText(json.getString("gstrbsix"));
                t7.setText(json.getString("gstrbseven"));
                t8.setText(json.getString("gstrbeight"));

                tt1.setText(json.getString("dateone"));
                tt2.setText(json.getString("datetwo"));
                tt3.setText(json.getString("datethree"));
                tt4.setText(json.getString("datefour"));
                tt5.setText(json.getString("datefive"));
                tt6.setText(json.getString("datesix"));
                tt7.setText(json.getString("dateseven"));
                tt8.setText(json.getString("dateeight"));

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }



        }
    }



}
