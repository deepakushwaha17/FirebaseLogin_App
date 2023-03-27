package com.deepa.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterUser extends AppCompatActivity {

    EditText email, password;
    Button btn, backtologin;
    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);



        email = findViewById(R.id.editTextTextEmailAddress2);
        password = findViewById(R.id.editTextTextPassword2);
        btn = findViewById(R.id.button2);
        backtologin = findViewById(R.id.button3);

        Auth = FirebaseAuth.getInstance();

        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterUser.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final   String memail = email.getText().toString();
                final     String mpassword = password.getText().toString();

                Auth.createUserWithEmailAndPassword(memail,mpassword).addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterUser.this, "USER CREATED", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Dashboard.class));
                    }else {
                        Toast.makeText(RegisterUser.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                });






            }
        });

    }
}