package com.example.sairam.mom;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by sai ram on 14-03-2017.
 */

public class BackGroundTask extends AsyncTask<String,Void,String> {

    Context c;
    BackGroundTask(Context c){
        this.c=c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url="http://192.168.0.5/android_connect/add_mother.php";
        String login_url="http://192.168.0.5/android_connect/login_mo.php";
        String method=params[0];
        if(method.equals("Register"))
        {
            String first=params[1];
            String last=params[2];
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data= URLEncoder.encode("first_name","UTF-8")+"="+URLEncoder.encode(first,"UTF-8")+"&"+
                             URLEncoder.encode("last_name","UTF-8")+"="+URLEncoder.encode(last,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                return "Registeration Sucessfull";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(c,result,Toast.LENGTH_LONG).show();
    }
}
