package com.gst.pcp.best;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import pl.droidsonroids.gif.GifImageView;


public class gstreturn extends AppCompatActivity {

    CardView pdf1,pdf2,pdf3,pdf4,pdf5,pdf6,pdf7,pdf8,pdf9,pdf10,pdf11,pdf12,pdf13,pdf14,pdf15,pdf16;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    private Toolbar mToolbar;
    private GifImageView g;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gstreturn);


        g=(GifImageView)findViewById(R.id.gif);

        pdf1=(CardView)findViewById(R.id.pdf1);
        pdf2=(CardView)findViewById(R.id.pdf2);
        pdf3=(CardView)findViewById(R.id.pdf3);
        pdf4=(CardView)findViewById(R.id.pdf4);
        pdf5=(CardView)findViewById(R.id.pdf5);
        pdf6=(CardView)findViewById(R.id.pdf6);
        pdf7=(CardView)findViewById(R.id.pdf7);
        pdf8=(CardView)findViewById(R.id.pdf8);
        pdf9=(CardView)findViewById(R.id.pdf9);
        pdf10=(CardView)findViewById(R.id.pdf10);
        pdf11=(CardView)findViewById(R.id.pdf11);
        pdf12=(CardView)findViewById(R.id.pdf12);
        pdf13=(CardView)findViewById(R.id.pdf13);
        pdf14=(CardView)findViewById(R.id.pdf14);
        pdf16=(CardView)findViewById(R.id.pdf16);
        pdf15=(CardView)findViewById(R.id.pdf15);

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(gstreturn.this,QuestionForm.class);
                startActivity(intent);
            }
        });

        pdf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-1.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-2.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });
        pdf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-3.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-4.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-5.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });
        pdf6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-6.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-7.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-8.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-9.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR 10.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-11.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR-1A.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR2-A.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });

        pdf14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR4-A.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });


        pdf15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR6-A.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


            }
        });


        pdf16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri url= Uri.parse("https://seedgst.in/GSTR7-A.pdf");
                Intent i=new Intent(Intent.ACTION_VIEW,url);

                startActivity(i);


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
                Intent intent=new Intent(gstreturn.this,QuestionForm.class);
                startActivity(intent);
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
        Intent intent=new Intent(gstreturn.this,About.class);
        startActivity(intent);
    }
    public void home()
    {
        Intent intent=new Intent(gstreturn.this,homepage.class);
        startActivity(intent);
    }
    public void contact()
    {
        Intent intent=new Intent(gstreturn.this,About.class);
        startActivity(intent);
    }
    public void faq()
    {
        Intent intent=new Intent(gstreturn.this,newFaq.class);
        startActivity(intent);
    }

    public void dates()
    {
        Intent intent=new Intent(gstreturn.this,impdates.class);
        startActivity(intent);
    }
    public void charts()
    {
        Intent intent=new Intent(gstreturn.this,gstchart.class);
        startActivity(intent);
    }
    public void profile()
    {
        Intent intent=new Intent(gstreturn.this,profile.class);
        startActivity(intent);
    }

    public void returns()
    {
        Intent intent=new Intent(gstreturn.this,gstreturn.class);
        startActivity(intent);
    }


    public void works()
    {
        Intent intent=new Intent(gstreturn.this,HAW.class);
        startActivity(intent);
    }

    public void terms()
    {
        Intent intent=new Intent(gstreturn.this,TNC.class);
        startActivity(intent);
    }
    public void signout()
    {

        new AlertDialog.Builder(gstreturn.this)
                .setIcon(android.R.drawable.ic_lock_lock)
                .setTitle("Sign out")
                .setMessage("Do You want to Sign out ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        new user(gstreturn.this).removeUser();

                        Intent intent=new Intent(gstreturn.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }



}
