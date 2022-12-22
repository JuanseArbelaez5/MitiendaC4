package com.example.mitiendac4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mitiendac4.DataBases.DBFirebases;
import com.example.mitiendac4.Entidades.Producto;

public class Form extends AppCompatActivity {
    private DBFirebases dbFirebases;
    private Button btnForm;
    private EditText editNameForm, editDescForm, editPriceForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnForm = (Button) findViewById(R.id.btnForm);
        editNameForm = (EditText) findViewById(R.id.editNameForm);
        editDescForm = (EditText) findViewById(R.id.editDescForm);
        editPriceForm = (EditText) findViewById(R.id.editPriceForm);
        dbFirebases = new DBFirebases();

        Intent intentIN = getIntent();
        if(intentIN.getBooleanExtra("edit",false)){
            editNameForm.setText(intentIN.getStringExtra("name"));
            editDescForm.setText(intentIN.getStringExtra("description"));
            editPriceForm.setText(intentIN.getStringExtra("price"));
        }

        btnForm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Producto producto = new Producto(
                        editNameForm.getText().toString(),
                        editDescForm.getText().toString(),
                        Integer.parseInt(editPriceForm.getText().toString()),
                        "",
                        "",
                        ""
                );
                if(intentIN.getBooleanExtra("edit",false)){
                    producto.setId(intentIN.getStringExtra("id"));
                    dbFirebases.updateData(producto);
                }else{
                    dbFirebases.insertData(producto);
                }
                Intent intent = new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);
            }
        });

    }
}