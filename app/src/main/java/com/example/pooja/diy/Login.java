package com.example.pooja.diy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText Email,Password;
    Button login,register;
    Databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new Databasehelper(this);
        login=findViewById(R.id.button);
        register=findViewById(R.id.button2);
        Email=findViewById(R.id.editText);
        Password=findViewById(R.id.editText2);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t=new Intent(getApplicationContext(),Register.class);
                startActivity(t);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Email.getText().toString();
                String pswd = Password.getText().toString();
                boolean res = db.checkUser(user,pswd);

                if(user.equals("") || pswd.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter valid details ",Toast.LENGTH_SHORT).show();
                }


               if(res == true ) {
                    Intent i=new Intent( getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"logged in ",Toast.LENGTH_SHORT).show();
                }


                else
                {
                    Toast.makeText(getApplicationContext(),"Login Error",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
