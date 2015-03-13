package com.littleo.netpda;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                String email;
                String pass;
                EditText et1 = (EditText) findViewById(R.id.email);
                EditText et2 = (EditText) findViewById(R.id.pass);
                email = et1.getText().toString();
                pass = et2.getText().toString();
                Toast.makeText(MainActivity.this,email,Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,pass,Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,NetPDA.class));
            }
        });
    }
}
