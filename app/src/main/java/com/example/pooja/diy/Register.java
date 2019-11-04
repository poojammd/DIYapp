package com.example.pooja.diy;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity  {
    EditText name,email,password;
    Button reg,login;
    Databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=new Databasehelper(this);
        name=findViewById(R.id.editText5);
        email=findViewById(R.id.editText3);
        password=findViewById(R.id.editText4);
        reg=findViewById(R.id.button3);
        login=findViewById(R.id.button4);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = email.getText().toString();
                String pass = password.getText().toString();
                 if(user.length()>1 && pass.length()>1){


                long val = db.addUser(user,pass);
                if(val > 0)
                {
                    Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
                }
                 }
                else
                {
                    Toast.makeText(getApplicationContext(),"Registration Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t=new Intent(getApplicationContext(),Login.class);
                startActivity(t);
            }
        });


    }

}
