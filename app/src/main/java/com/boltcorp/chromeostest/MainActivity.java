package com.boltcorp.chromeostest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView fingerprintView,supportedABIs,baseOS,osArch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getApplicationContext().getPackageManager().hasSystemFeature("org.chromium.arc.device_management"))
        {
            String fingerprint= Build.FINGERPRINT;
            String[] cpu = Build.SUPPORTED_ABIS;

            String[] fingerprintArray = fingerprint.split("[/]");
            String[] androidVersion = fingerprintArray[2].split("[:]");


            fingerprintView = findViewById(R.id.fingerprintView);
            supportedABIs = findViewById(R.id.supportedABIs);
            baseOS = findViewById(R.id.baseOS);
            osArch = findViewById(R.id.osArch);

            fingerprintView.setText(fingerprint);
            supportedABIs.setText(cpu[0]);
            baseOS.setText(androidVersion[1]);
            osArch.setText(fingerprintArray[3]);
        }


    }
}
