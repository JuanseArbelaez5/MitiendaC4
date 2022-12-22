package com.example.mitiendac4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private Button btnLoginReg;
    private EditText editemailReg, editPassConfirmreg, editPassreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnLoginReg = (Button) findViewById(R.id.btnLoginReg);
        editemailReg = (EditText) findViewById(R.id.editemailReg);
        editPassConfirmreg = (EditText) findViewById(R.id.editPassConfirmreg);
        editPassreg = (EditText) findViewById(R.id.editPassreg);

        btnLoginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editemailReg.getText().toString();
                String pass = editemailReg.getText().toString();
                String confirm = editemailReg.getText().toString();

                if(pass.compareTo(confirm) == 0){
                    FirebasbaseAuth mAuth;
                    // ...
                    // Initialize Firebase Auth
                    mAuth = FirebaseAuth.getInstance();

                }else{
                    Toast.makeText(getApplicationContext(),"Contraseña no coincide", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}