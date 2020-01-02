package com.gst.pcp.best;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import pl.droidsonroids.gif.GifImageView;


public class TNC extends AppCompatActivity {

    private GifImageView g;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tnc);

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        g=(GifImageView)findViewById(R.id.gif);


        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TNC.this,QuestionForm.class);
                startActivity(intent);
            }
        });
    }
}
