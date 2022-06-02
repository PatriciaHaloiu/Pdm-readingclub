package com.example.readingclub1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SingUp extends AppCompatActivity {

    TextInputLayout  regUsername, regPassword, regCheck;
    Button regBtn, regToLogBtn;
    DBHelper DB;

    //FirebaseDatabase rootNode;
    // DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        //Hooks
        //regName = findViewById((R.id.reg_name));
        regUsername = findViewById((R.id.reg_username));
        //regPhoneNo = findViewById((R.id.reg_phoneNo));
        regPassword = findViewById((R.id.reg_password));
        regToLogBtn = findViewById((R.id.reg_login_btn));
        regBtn = findViewById((R.id.reg_btn));
        regCheck = findViewById(R.id.reg_check);
        DB = new DBHelper(this);

        //Save date in firebase
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String username = regUsername.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();
                String check = regCheck.getEditText().getText().toString();

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(check)){
                    Toast.makeText(SingUp.this, "Introduce usernameul si parola", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.equals(check)){
                        Boolean checkuser = DB.checkusername(username);
                        if (checkuser == false){
                            Boolean insert = DB.insertData(username,password);
                            if(insert==true){
                                Toast.makeText(SingUp.this, "Succes", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Home.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SingUp.this, "Fail", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SingUp.this, "Userul deja exista", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SingUp.this, "Parola nu se potriveste", Toast.LENGTH_SHORT).show();
                    }
                }





            }
        });

        regToLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
}