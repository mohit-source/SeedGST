package com.gst.pcp.best;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
 * Created by PCP on 30-12-2017.
 */

public class BackgroundLogin extends AsyncTask<String,Void,String> {
    Context contextb;
   // AlertDialog alertDialog;
    ProgressDialog loading;
    String json_url="http://seedgst.in/json_get_data.php";
    BackgroundLogin(Context ctx) {
        contextb = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String typeb = params[0];
        String login_url = "http://seedgst.in/login.php";
        //String register_url = "http://seedgst.in/register.php";
        if (typeb.equals("login")) {
            try {
                String user_mob = params[1];
                String user_pass = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_mob", "UTF-8") + "=" + URLEncoder.encode(user_mob, "UTF-8") + "&"
                        + URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String resultb = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    resultb += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return resultb;
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
       loading = ProgressDialog.show(contextb, "Please Wait", null, false, false);
    }

    @Override
    protected void onPostExecute(String resultb) {
        // alertDialog.setMessage(result);
        // alertDialog.show();
        loading.dismiss();



     if(resultb.contentEquals("Login success")) {



            contextb.startActivity(new Intent(contextb, homepage.class));


        }
        else
        {


            new user(contextb).removeUser();
            Toast toast= Toast.makeText(contextb, "Email or password is wrong", Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
