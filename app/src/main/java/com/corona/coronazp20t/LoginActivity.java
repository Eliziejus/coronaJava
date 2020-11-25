package com.corona.coronazp20t;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//atidaromas langas (tuscias)
        setContentView(R.layout.activity_login);//pridek prie to lango, vaizda
        //kodas rasomas nuo cia
        Button register=findViewById(R.id.register);
        Button login=findViewById(R.id.login);//susiejamas vaizde esantis elementa su kodu
        final EditText username=findViewById(R.id.username);
        final EditText password=findViewById(R.id.password);

        //bus sukurtas User klases objektas
        final User user=new User(LoginActivity.this);
        final CheckBox rememberMe=findViewById(R.id.remember_me);
        rememberMe.setChecked(user.isRememberedForLogin());
        if (rememberMe.isChecked()) {
            username.setText(user.getUsernameForLogin(), TextView.BufferType.EDITABLE);
            password.setText(user.getPasswordForLogin(), TextView.BufferType.EDITABLE);
        } else{//bus vykdomas tuo atveju kai vartotojos paskutini karta jungdamasis prie aplikacijos nepažymėjo checkbox
            username.setText("",TextView.BufferType.EDITABLE);
            password.setText("",TextView.BufferType.EDITABLE);
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegistration=new Intent(LoginActivity.this,Registration.class);
                startActivity(goToRegistration);
            }

        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cia rasomas kodas kuris vykdomas paspaudus mygtuka

                if (Validation.isValidUsername(username.getText().toString()) &&
                        Validation.isValidPassword(password.getText().toString())){
                    user.setUsernameForLogin(username.getText().toString());
                    user.setPasswordForLogin(password.getText().toString());
                    if(rememberMe.isChecked()){
                        user.setRememberMeForLogin(true);
                    }else{
                        user.setRememberMeForLogin(false);
                    }

                    //ketinimas pereiti i paieskos langa                is kur            į kur
                    Intent goToSeachActivity=new Intent(LoginActivity.this,SeachActivity.class);
                    startActivity(goToSeachActivity);

                }
                else{//Jeigu vartotojas ivede bloga prisijungimo varda
                    username.setError(getResources().getString(R.string.login_invalid_username));
                    username.requestFocus();
                }

            }
        });

    }

}
