package com.example.mitiendac4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    private Button btnInfo;
    private TextView textNameInfo, textDescInfo, textPriceInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btnInfo = (Button) findViewById(R.id.btnInfo);
        textNameInfo = (TextView) findViewById(R.id.textNameInfo);
        textDescInfo = (TextView) findViewById(R.id.textDescInfo);
        textPriceInfo = (TextView) findViewById(R.id.textPriceInfo);

        Intent intentIN = getIntent();
        textNameInfo.setText(intentIN.getStringExtra("name"));
        textDescInfo.setText(intentIN.getStringExtra("description"));
        textPriceInfo.setText(intentIN.getStringExtra("price"));

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);
            }
        });
    }
}