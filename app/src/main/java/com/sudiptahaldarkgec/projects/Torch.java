package com.sudiptahaldarkgec.projects;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Torch extends AppCompatActivity {

    TextView textView;
    AppCompatToggleButton toggleButton;
    CameraManager cameraManager;
    String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);

        textView = findViewById(R.id.torchtextId);
        toggleButton = findViewById(R.id.toggleButtonId);

        textView.setText("Flash Light off");
        boolean isFlashAvailable = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if(!isFlashAvailable){
            flashNotFoundError();
        }
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        }
        catch (CameraAccessException e){
            e.printStackTrace();
        }

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switchFlashLight(b);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.M)

    public void switchFlashLight(boolean status){
        try {
            if(status){
                textView.setText("light on");
            }
            else{

                textView.setText("light off");
            }
            cameraManager.setTorchMode(cameraId, status);
        }
        catch (CameraAccessException e){
            e.printStackTrace();
        }
    }
    public void flashNotFoundError(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Oops");

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.show();
    }
}