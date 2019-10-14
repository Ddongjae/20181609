package com.cookandroid.homework;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.cookandroid.homework.MainActivity.IDList;
import static com.cookandroid.homework.MainActivity.PWList;
import static com.cookandroid.homework.MainActivity.NameList;
import static com.cookandroid.homework.MainActivity.PhoneList;
import static com.cookandroid.homework.MainActivity.AddressList;

public class signupActivity extends Activity {
    Boolean IDCheck = false;
    Boolean PWcheck = false;
    @Override
    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.signup);

        Button btnIDChecked = (Button) findViewById(R.id.btnIDChecked);
        final Button btnPWChecked = (Button) findViewById(R.id.btnPWChecked);
        final EditText editSignUpID = (EditText) findViewById(R.id.editSignUpID);
        final EditText editSignUpPW = (EditText) findViewById(R.id.editSignUpPW);
        final EditText editSignName = (EditText) findViewById(R.id.editSignName);
        final EditText editPhone = (EditText) findViewById(R.id.editPhone);
        final EditText editAddress = (EditText) findViewById(R.id.editAddress);
        btnIDChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean overlap = false;
                for(int i=0; i<IDList.size();i++){
                    if(editSignUpID.getText().toString().equals(IDList.get(i))){
                        overlap = true;
                    }
                }
                if(overlap == false){
                    IDCheck = true;
                    Toast.makeText(getApplicationContext(),
                            "사용가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    IDCheck = false;
                    Toast.makeText(getApplicationContext(),
                            "중복된 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPWChecked.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editSignUpPW.getText().toString().length()<10){
                    PWcheck = false;
                    Toast.makeText(getApplicationContext(),
                            "10자리 이상의 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else{
                    PWcheck = true;
                    Toast.makeText(getApplicationContext(),
                            "확인", Toast.LENGTH_SHORT).show();
                }

            }
        }));
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setEnabled(false);
        RadioGroup rg = (RadioGroup) findViewById(R.id.rGroup1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.btnYes){
                    btnRegister.setEnabled(true);
                }
                else{
                    btnRegister.setEnabled(false);
                }
            }
        });
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IDCheck == true){
                    if(PWcheck == true){
                        if(editSignName.getText().toString().length()==0){
                            Toast.makeText(getApplicationContext(),
                                    "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if(editPhone.getText().toString().length()==0){
                                Toast.makeText(getApplicationContext(),
                                        "휴대폰번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                if(editAddress.getText().toString().length()==0){
                                    Toast.makeText(getApplicationContext(),
                                            "주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),
                                            "회원가입이 완료되었습니다. \n로그인을 해주세요.",
                                            Toast.LENGTH_SHORT).show();
                                    IDList.add(editSignUpID.getText().toString());
                                    PWList.add(editSignUpPW.getText().toString());
                                    NameList.add(editSignName.getText().toString());
                                    PhoneList.add(editPhone.getText().toString());
                                    AddressList.add(editAddress.getText().toString());
                                    finish();
                                }
                            }
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),
                                "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "아이디를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),
                        "로그인화면으로 이동",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
