package com.example.readingclub1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Return extends AppCompatActivity {

    TextInputLayout titlu1, autor1, user;
    Button rt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);

        titlu1 = findViewById(R.id.Carte1);
        autor1 = findViewById(R.id.autor1);
        rt = findViewById(R.id.rtnBtn);
        user = findViewById(R.id.user);

        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = titlu1.getEditText().getText().toString();
                String pass = autor1.getEditText().getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(Return.this, "Introdu datele", Toast.LENGTH_LONG).show();
                else {

                    Toast.makeText(Return.this, "Cartea a fost returnata", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                }

            }
        });
    }
}