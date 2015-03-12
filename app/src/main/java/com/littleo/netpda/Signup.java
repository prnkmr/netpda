package com.littleo.netpda;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Signup extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button bt1 = (Button) findViewById(R.id.registerbutton);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass1, pass2;
                EditText et2, et3;
                et2 = (EditText) findViewById(R.id.pass);
                et3 = (EditText) findViewById(R.id.retype);
                pass1=et2.getText().toString();
                pass2=et3.getText().toString();
                if(pass1.equals(pass2)) {
                    String name, dob, designation, contactnum, email, description;
                    EditText et1, et4, et5, et6, et7, et8;
                    et1 = (EditText) findViewById(R.id.username);
                    et4 = (EditText) findViewById(R.id.dob);
                    et5 = (EditText) findViewById(R.id.designation);
                    et6 = (EditText) findViewById(R.id.contactnum);
                    et7 = (EditText) findViewById(R.id.email);
                    et8 = (EditText) findViewById(R.id.description);
                    name = et1.getText().toString();
                    dob=et4.getText().toString();
                    designation=et5.getText().toString();
                    contactnum=et6.getText().toString();
                    email=et7.getText().toString();
                    description=et8.getText().toString();
                    Toast.makeText(Signup.this,name,Toast.LENGTH_LONG).show();
                    Toast.makeText(Signup.this,pass1,Toast.LENGTH_LONG).show();
                    Toast.makeText(Signup.this,dob,Toast.LENGTH_LONG).show();
                    Toast.makeText(Signup.this,designation,Toast.LENGTH_LONG).show();
                    Toast.makeText(Signup.this,contactnum,Toast.LENGTH_LONG).show();
                    Toast.makeText(Signup.this,email,Toast.LENGTH_LONG).show();
                    Toast.makeText(Signup.this,description,Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Signup.this,"PASSWORD MISMATCH",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
