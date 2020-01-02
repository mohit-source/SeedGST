package com.gst.pcp.best;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by PCP on 28-12-2017.
 */

public class BackgroundQuestion extends AsyncTask<String,Void,String> {

    Context contextc;
    AlertDialog alertDialog;
    ProgressDialog loading;
    BackgroundQuestion (Context ctx) {
        contextc = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        String question_url = "http://seedgst.in/askquestion.php";

        if(type.equals("quest")){
            try {
                String newquestion = params[1];
                String nmob = params[2];
                String boolq = params[3];
                URL url = new URL(question_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("newquestion","UTF-8")+"="+URLEncoder.encode(newquestion,"UTF-8")+"&"+
                        URLEncoder.encode("nmob","UTF-8")+"="+URLEncoder.encode(nmob,"UTF-8")+"&"+
                        URLEncoder.encode("boolq","UTF-8")+"="+URLEncoder.encode(boolq,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String resultc="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    resultc += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return resultc;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onPreExecute() {
        //alertDialog = new AlertDialog.Builder(context).create();
        // alertDialog.setTitle("Login Status");
       loading = ProgressDialog.show(contextc, "Please Wait", null, false, false);

    }

    @Override
    protected void onPostExecute(String result) {
        // alertDialog.setMessage(result);
        // alertDialog.show();
        loading.dismiss();
        Toast.makeText(contextc, "Your Message has been sent...Wait for Reply !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}