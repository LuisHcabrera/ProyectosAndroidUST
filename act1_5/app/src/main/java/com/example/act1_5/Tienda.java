package com.example.act1_5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class Tienda extends MainActivity{

    RadioButton dom;
    CheckBox op1,op2,op3,op4,op5,op6,op7,op8;
    Button bcalcular, bcancelar;
    TextView ttotal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiendapedidos);

        dom=findViewById(R.id.rbDomicilio);
        op1=findViewById(R.id.checkBoxpolera);
        op2=findViewById(R.id.checkBoxZapatilla);
        op3=findViewById(R.id.checkBoxBolso);
        op4=findViewById(R.id.checkBoxBuzo);
        op5=findViewById(R.id.checkBoxPantalon);
        op6=findViewById(R.id.checkBoxZapatillas2);
        op7=findViewById(R.id.checkBoxCamisa);
        op8=findViewById(R.id.checkBoxAccesorio);
        ttotal=findViewById(R.id.txtTotal);
    }
    public void calcular(View v){
        Double total =0.0;
        if (dom.isChecked())
            total = total + 3000;
        if (op1.isChecked())
            total = total + 5000;
        if (op2.isChecked())
            total = total + 45000;
        if (op3.isChecked())
            total = total + 6000;
        if (op4.isChecked())
            total = total + 25000;
        if (op5.isChecked())
            total = total + 20000;
        if (op6.isChecked())
            total = total + 40000;
        if (op7.isChecked())
            total = total + 15000;
        if (op8.isChecked())
            total = total + 40000;
        ttotal.setText("Total: "+total);

    }
    public void cancelar (View v){
        dom.setChecked(false);
        op1.setChecked(false);
        op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);
        ttotal.setText("Total=0");

    }
}
