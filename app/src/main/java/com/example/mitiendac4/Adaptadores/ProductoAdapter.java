package com.example.mitiendac4.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mitiendac4.Catalogo;
import com.example.mitiendac4.DataBases.DBFirebases;
import com.example.mitiendac4.Entidades.Producto;
import com.example.mitiendac4.Form;
import com.example.mitiendac4.Info;
import com.example.mitiendac4.R;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> arrayProducto;

    public ProductoAdapter(Context context, ArrayList<Producto> arrayProducto) {
        this.context = context;
        this.arrayProducto = arrayProducto;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Producto> getArrayProducto() {
        return arrayProducto;
    }

    public void setArrayProducto(ArrayList<Producto> arrayProducto) {
        this.arrayProducto = arrayProducto;
    }

    @Override
    public int getCount() {
        return arrayProducto.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProducto.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.producto_template, null);

        Producto producto = arrayProducto.get(i);

        ImageView imageProd = (ImageView) view.findViewById(R.id.imageProd);
        TextView textNameProd = (TextView)  view.findViewById(R.id.textNameProd);
        TextView textDescProd = (TextView)  view.findViewById(R.id.textDescProd);
        TextView textPriceProd = (TextView)  view.findViewById(R.id.textPriceProd);
        Button btnEdit = (Button) view.findViewById(R.id.btnEdit);
        Button btnDelete = (Button) view.findViewById(R.id.btnDelete);

        imageProd.setImageResource(R.drawable.producto1);
        textNameProd.setText(producto.getName());
        textDescProd.setText(producto.getDescription());
        textPriceProd.setText(String.valueOf(producto.getPrice()));
        imageProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Info.class);
                intent.putExtra("name", producto.getName());
                intent.putExtra("description", producto.getDescription());
                intent.putExtra("price", String.valueOf(producto.getPrice()));
                context.startActivity(intent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DBFirebases dbFirebases= new DBFirebases();
                dbFirebases.deleteData(producto.getId());
                Intent intent = new Intent(context, Catalogo.class);
                context.startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Form.class);
                intent.putExtra("edit", true);
                intent.putExtra("id", producto.getId());
                intent.putExtra("name", producto.getName());
                intent.putExtra("description", producto.getDescription());
                intent.putExtra("price", String.valueOf(producto.getPrice()));
                intent.putExtra("image", producto.getImage());
                intent.putExtra("longitud", producto.getLongitud());
                intent.putExtra("latitud", producto.getLatitud());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
