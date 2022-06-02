package com.example.readingclub1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculeaza extends AppCompatActivity {

    Button calculeaza;
    EditText TextA;
    EditText TextB;
    EditText result;

    private static double x;
    private static double total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculeaza);

        calculeaza = findViewById(R.id.calculeazaBtn);
        TextA = findViewById(R.id.valpag);
        TextB = findViewById(R.id.valtimp);
        result = findViewById(R.id.ResultText);

        calculeaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = 0, b = 0;
                try {
                    a = Double.parseDouble(TextA.getText().toString());
                    b = Double.parseDouble(TextB.getText().toString());
                } catch (NumberFormatException e) {
                }
                if(a>0 && b>0){
                    x = a*b;
                    total = x/60;
                }
                result.setText("In "+total + " ore");
            }
        });
    }
}