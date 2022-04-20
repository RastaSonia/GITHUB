package com.example.activity_ers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if(usernameKey.equals("Rasta") && passwordKey.equals("12345")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,menu_utama.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }else{
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau Password Anda salah ")
                            .setNegativeButton("Retry",null).create().show();


                }
            }
        });
    }
}