package com.example.readingclub1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Issue extends AppCompatActivity {

    TextInputLayout titlu, autor;
    Button imp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);

        titlu = findViewById(R.id.Carte);
        autor = findViewById(R.id.autor);
        imp = findViewById(R.id.impBtn);

        imp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = titlu.getEditText().getText().toString();
                String pass = autor.getEditText().getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(Issue.this, "Introdu datele", Toast.LENGTH_LONG).show();
                else {

                    Toast.makeText(Issue.this, "Imprumut realizat", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                }
            }
        });
    }
}
