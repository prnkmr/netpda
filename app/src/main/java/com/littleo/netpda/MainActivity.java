package com.littleo.netpda;

import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    //@Override
    private SharedPreferences pref;
    private String baseURL="http://abijithkrish.t15.org/netpda/";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(android.os.Build.VERSION.SDK_INT>9){
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        setContentView(R.layout.activity_main);
        String loginid=null;
        pref=getSharedPreferences("login",0);
        loginid = pref.getString("loginid","notloggedin");
        if(loginid.equals("notloggedin")) {

            Button b1=(Button) findViewById(R.id.signup);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,Signup.class));
                }
            });
            Button bt2 =(Button) findViewById(R.id.login);
            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_LONG).show();
                    String email;
                    String pass;
                    EditText et1 = (EditText) findViewById(R.id.email);
                    EditText et2 = (EditText) findViewById(R.id.pass);
                    email = et1.getText().toString();
                    pass = et2.getText().toString();
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost(baseURL+"verifylogin.php");

                    try {
                        // Add your data
                        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                        nameValuePairs.add(new BasicNameValuePair("uname", email));
                        nameValuePairs.add(new BasicNameValuePair("password", pass));
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                        // Execute HTTP Post Request
                        HttpResponse response = httpclient.execute(httppost);
                        //response.getEntity().getContent()
                        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                        System.out.println(reader.readLine());
                        Toast.makeText(getApplicationContext(),"Got resp",Toast.LENGTH_LONG).show();
                    } catch (ClientProtocolException e) {
                        // TODO Auto-generated catch block
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                    }
                    //Toast.makeText(MainActivity.this,email,Toast.LENGTH_LONG).show();
                    //Toast.makeText(MainActivity.this,pass,Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(MainActivity.this,NetPDA.class));

                }
            });
        }
        else {
            startActivity(new Intent(MainActivity.this,NetPDA.class));
            //finish();
        }

    }
}
