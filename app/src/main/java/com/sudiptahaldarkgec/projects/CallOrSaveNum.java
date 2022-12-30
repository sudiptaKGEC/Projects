package com.sudiptahaldarkgec.projects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CallOrSaveNum extends AppCompatActivity {
    EditText number;
    AppCompatButton callButton, saveButton;
    String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_or_save_num);

        number = findViewById(R.id.callEditTextId);
        callButton = findViewById(R.id.callButtonId);
        saveButton = findViewById(R.id.saveNumButtonId);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                mobileNumber = number.getText().toString();

                if(mobileNumber.equals("")){
                    Toast.makeText(CallOrSaveNum.this, "Enter a Number Please", Toast.LENGTH_SHORT).show();
                }
                else{
                    intent.setData(Uri.parse("tel:" + mobileNumber)); //in the "tel:" position there should not be any gap write as it write here "tel:"
                    if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(CallOrSaveNum.this, "permission not granted", Toast.LENGTH_SHORT).show();
                        ActivityCompat.requestPermissions(CallOrSaveNum.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    }
                    else {
                        startActivity(intent);
                    }
                }
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                mobileNumber = number.getText().toString();

                if(mobileNumber.equals("")){
                    Toast.makeText(CallOrSaveNum.this, "Enter a Number Please", Toast.LENGTH_SHORT).show();
                }
                else{
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE, mobileNumber);
                    startActivity(intent);
                }

            }
        });
    }
}