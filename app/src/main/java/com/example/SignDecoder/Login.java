package com.example.SignDecoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://learnoset-b568d-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password);
        final Button loginBtn = findViewById(R.id.loginBtn);
        final TextView registerNowBtn = findViewById(R.id.registerNowBtn);
//        final String str="";


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();
                if(phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Login.this,"Please Enter Mobile or Password",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if phone(user) exists in database or not
                            if(snapshot.hasChild(phoneTxt)){
                                //mobile(user) exists
                                //now get pass from user and match password
                                //1st collect pass from DB
                                final String getPassword = snapshot.child(phoneTxt).child("password").getValue(String.class);
                                 final String str = snapshot.child(phoneTxt).child("i").getValue(String.class);
                                final String n = snapshot.child(phoneTxt).child("fullname").getValue(String.class);



                                //now check with given pass
                                if(getPassword.equals(passwordTxt)){
                                    Toast.makeText(Login.this,"Successfully Logged IN :D",Toast.LENGTH_SHORT).show();
                                    //open home page
                                    Intent intent = new Intent(Login.this, home.class);
                                    intent.putExtra("sms", str);
                                    intent.putExtra("name", n);

                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(Login.this,"Password Error 404",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Login.this,"Please Register First` :D",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }


//                startActivity(intent);

            }
        });


        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open register activity
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}