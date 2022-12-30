package com.sudiptahaldarkgec.projects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PhoneDetails extends AppCompatActivity {
    TextView deviceInfo;
    AppCompatButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_details);

        deviceInfo = findViewById(R.id.deviceInfoId);
        button = findViewById(R.id.phoneDetailsButtonId);


        initListener();
    }
    public void initListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = getHardAndSoftware();
                deviceInfo.setText(info);
            }
        });
    }
    private String getHardAndSoftware(){
        return "SERIAL: "+ " " + Build.SERIAL + "\n"+
                "MODEL        : "+ " " + Build.MODEL + "\n"+
                "ID           : "+ " " + Build.ID + "\n"+
                "MANUFACTURE  : "+ " " + Build.MANUFACTURER + "\n"+
                "BRAND        : "+ " " + Build.BRAND + "\n"+
                "TYPE         : "+ " " + Build.TYPE + "\n"+
                "USER         : "+ " " + Build.USER + "\n"+
                "BASE         : "+ " " + Build.VERSION_CODES.BASE + "\n"+
                "INCREMENTAL  : "+ " " + Build.VERSION.INCREMENTAL + "\n"+
                "BOARD        : "+ " " + Build.BOARD + "\n"+
                "SDK_INT      : "+ " " + Build.VERSION.SDK_INT + "\n"+
                "HOST         : "+ " " + Build.HOST + "\n"+
                "FINGERPRINT  : "+ " " + Build.FINGERPRINT + "\n"+
                "RELEASE      : "+ " " + Build.VERSION.RELEASE + "\n"+
                "PRODUCT      : "+ " " + Build.PRODUCT + "\n"+
                "DEVICE       : "+ " " + Build.DEVICE + "\n"+
                "TIME : "+ " " + Build.TIME + "\n"+
                "TAGS : "+ " " + Build.TAGS + "\n";

    }
}