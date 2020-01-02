package com.gst.pcp.best;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import pl.droidsonroids.gif.GifImageView;

public class gstupdates extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    private Toolbar mToolbar;

    private GifImageView g;
    private Button clickherebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gstupdates);

        g=(GifImageView)findViewById(R.id.gif);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(gstupdates.this,QuestionForm.class);
                startActivity(intent);
            }
        });

        clickherebtn=(Button)findViewById(R.id.latestupdt);

        clickherebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url= Uri.parse("https://www.gst.gov.in/newsandupdates");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);
            }
        });

        g=(GifImageView)findViewById(R.id.gif);

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(gstupdates.this,QuestionForm.class);
                startActivity(intent);
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
        Intent intent=new Intent(gstupdates.this,About.class);
        startActivity(intent);
    }
    public void home()
    {
        Intent intent=new Intent(gstupdates.this,homepage.class);
        startActivity(intent);
    }
    public void contact()
    {
        Intent intent=new Intent(gstupdates.this,About.class);
        startActivity(intent);
    }
    public void faq()
    {
        Intent intent=new Intent(gstupdates.this,newFaq.class);
        startActivity(intent);
    }

    public void dates()
    {
        Intent intent=new Intent(gstupdates.this,impdates.class);
        startActivity(intent);
    }

    public void profile()
    {
        Intent intent=new Intent(gstupdates.this,profile.class);
        startActivity(intent);
    }
    public void charts()
    {
        Intent intent=new Intent(gstupdates.this,gstchart.class);
        startActivity(intent);
    }

  public void returns()
    {
        Intent intent=new Intent(gstupdates.this,gstreturn.class);
        startActivity(intent);
    }


    public void works()
    {
        Intent intent=new Intent(gstupdates.this,HAW.class);
        startActivity(intent);
    }

    public void terms()
    {
        Intent intent=new Intent(gstupdates.this,TNC.class);
        startActivity(intent);
    }
    public void signout()
    {
        new AlertDialog.Builder(gstupdates.this)
                .setIcon(android.R.drawable.ic_lock_lock)
                .setTitle("Sign out")
                .setMessage("Do You want to Sign out ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        new user(gstupdates.this).removeUser();

                        Intent intent=new Intent(gstupdates.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
