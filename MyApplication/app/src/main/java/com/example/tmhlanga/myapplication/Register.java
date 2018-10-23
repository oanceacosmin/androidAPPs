package com.example.tmhlanga.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    Button btnReg, btnCancel;
    EditText etfn, etsn, etpw, etgroup, etem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etfn = findViewById(R.id.et_reg_fn);
        etsn = findViewById(R.id.et_reg_sn);
        etem = findViewById(R.id.et_reg_em);
        etpw = findViewById(R.id.pet_reg_pw);
        etgroup = findViewById(R.id.et_reg_group);
        btnReg = findViewById(R.id.btn_reg_register);
        btnCancel = findViewById(R.id.btn_reg_cancel);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void reg()
    {
        UniSQL con = new UniSQL(this);
        con.register(etfn.getText().toString(), etsn.getText().toString(), etem.getText().toString(), etgroup.getText().toString(), etpw.getText().toString());
    }
}
