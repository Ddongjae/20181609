package com.cookandroid.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List IDList = new ArrayList();
    public static List PWList = new ArrayList();
    public static List NameList = new ArrayList();
    public static List PhoneList = new ArrayList();
    public static List AddressList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        IDList.add("admin");
        PWList.add("admin");
        NameList.add("admin");
        PhoneList.add("admin");
        AddressList.add("admin");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNewActivity = (Button) findViewById(R.id.btnSignUp);
        btnNewActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        signupActivity.class);
                startActivity(intent);
            }
        });
        Button btnNewActivity2 = (Button) findViewById(R.id.btnLogin);
        final EditText editID = (EditText) findViewById(R.id.editID);
        final EditText editPW = (EditText) findViewById(R.id.editPW);
        btnNewActivity2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                boolean pass = false;
                Intent intent = new Intent(getApplicationContext(),
                        afterLogin.class);
                int i; for(i=0; i<IDList.size(); i++){
                    if(editID.getText().toString().equals(IDList.get(i))==true){
                        pass = true;
                        break;
                    }
                }
                if(pass == true){
                    if(editPW.getText().toString().equals(PWList.get(i))==true){
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),
                                "비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "아이디를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
