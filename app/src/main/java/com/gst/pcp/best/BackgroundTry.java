package com.gst.pcp.best;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;


/**
 * Created by PCP on 28-12-2017.
 */

public class BackgroundTry extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    ProgressDialog loading;
    BackgroundTry (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {

            try {

              //  context.startActivity(new Intent(context, QuestionForm.class));

            } catch (Exception e) {
                e.printStackTrace();
            }

        return null;
    }


    @Override
    protected void onPreExecute() {
        //alertDialog = new AlertDialog.Builder(context).create();
        // alertDialog.setTitle("Login Status");
        loading = ProgressDialog.show(context, "Please Wait", null, false, false);
    }

    @Override
    protected void onPostExecute(String result) {
        // alertDialog.setMessage(result);
        // alertDialog.show();
        loading.dismiss();

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}