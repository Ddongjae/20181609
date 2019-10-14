package com.cookandroid.homework;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class afterLogin extends Activity {
    Boolean pickScissor = false;
    Boolean pickRock = false;
    Boolean pickPaper = false;
    Boolean pickPlayer = false;
    int pickCPU = 0;  //1=가위, 2=바위, 3=보


    @Override

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.login);

        Button btnScissor = (Button) findViewById(R.id.scissor);
        Button btnRock = (Button) findViewById(R.id.rock);
        Button btnPaper = (Button) findViewById(R.id.paper);
        Button btnBattle = (Button) findViewById(R.id.battle);
        btnScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickScissor = true;
                pickPaper = false;
                pickRock = false;
                pickPlayer = true;
                Toast.makeText(getApplicationContext(),
                        "가위를 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickRock = true;
                pickScissor = false;
                pickPaper = false;
                pickPlayer = true;
                Toast.makeText(getApplicationContext(),
                        "바위를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickPaper = true;
                pickScissor = false;
                pickRock = false;
                pickPlayer = true;
                Toast.makeText(getApplicationContext(),
                        "보를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        final TextView result = (TextView) findViewById(R.id.result);
        final ImageView playerImage = (ImageView) findViewById(R.id.playerImage);
        final ImageView cpuImage = (ImageView) findViewById(R.id.cpuImage);
        btnBattle.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickCPU = (int)(Math.random()*3+1);
                if(pickPlayer == true) {
                    if (pickCPU == 1) {
                        cpuImage.setImageResource(R.drawable.scissor);
                    } else if (pickCPU == 2) {
                        cpuImage.setImageResource(R.drawable.rock);
                    } else if (pickCPU == 3) {
                        cpuImage.setImageResource(R.drawable.paper);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "가위바위보 중 한개를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                if(pickScissor == true){
                    playerImage.setImageResource(R.drawable.scissor);
                    if(pickCPU == 1){
                        result.setText("DRAW!");
                    }
                    else if (pickCPU == 2){
                        result.setText("YOU LOSE!");
                    }
                    else if (pickCPU == 3){
                        result.setText("YOU WIN!");
                    }
                }
                else if(pickRock == true){
                    playerImage.setImageResource(R.drawable.rock);
                    if(pickCPU == 1){
                        result.setText("YOU WIN!");
                    }
                    else if (pickCPU == 2){
                        result.setText("DRAW!");
                    }
                    else if (pickCPU == 3){
                        result.setText("YOU LOSE!");
                    }
                }
                else if(pickPaper == true){
                    playerImage.setImageResource(R.drawable.paper);
                    if(pickCPU == 1){
                        result.setText("YOU LOSE!");
                    }
                    else if (pickCPU == 2){
                        result.setText("YOU WIN!");
                    }
                    else if (pickCPU == 3){
                        result.setText("DRAW!");
                    }
                }
            }
        }));

    }
}
