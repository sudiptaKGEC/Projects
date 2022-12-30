package com.sudiptahaldarkgec.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Goto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto);

        int projectItmNumber = getIntent().getIntExtra("key_position", 0);

        if(projectItmNumber == 0){
            Intent vibrate = new Intent(Goto.this, VibratorPage.class);
            startActivity(vibrate);
            finish();
        }
        else if(projectItmNumber == 1){
            Intent brightness = new Intent(Goto.this, Brightness.class);
            startActivity(brightness);
            finish();
        }
        else if(projectItmNumber == 2){
            Intent torch = new Intent(Goto.this, Torch.class);
            startActivity(torch);
            finish();
        }
        else if(projectItmNumber == 3){
            Intent torch = new Intent(Goto.this, PhoneDetails.class);
            startActivity(torch);
            finish();
        }
        else if(projectItmNumber == 4){
            Intent torch = new Intent(Goto.this, CallOrSaveNum.class);
            startActivity(torch);
            finish();
        }

    }
}