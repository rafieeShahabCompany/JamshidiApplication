package com.shahab.jamshidiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        TextView txtEntername = findViewById(R.id.txtEntername);
        TextView txtEnterfamily = findViewById(R.id.txtEnterfamily);
        TextView txtEnterage = findViewById(R.id.txtEnterage);
        TextView txtEnterphone = findViewById(R.id.txtEnterphone);
        TextView txtEnteraddress = findViewById(R.id.txtEnteraddress);
        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnConfirm = findViewById(R.id.btnConfirm);



        Intent i = getIntent();
        final String name = i.getStringExtra("name");
        final String family = i.getStringExtra("family");
        final String age = i.getStringExtra("age");
        final String phone = i.getStringExtra("phone");
        final String address = i.getStringExtra("address");

        txtEntername.setText("your name is: "+name);
        txtEnterfamily.setText("your family is: "+family);
        txtEnterage.setText("your age is: "+age);
        txtEnterphone.setText("your phone is: "+phone);
        txtEnteraddress.setText("your address is: "+address);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                setResult(Activity.RESULT_OK,ii);
                finish();
            }
        });


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("Name",name);
                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("FAMILY",family);
                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("AGE",age);
                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("PHONE",phone);
                PreferenceManager.getDefaultSharedPreferences(Confirm.this).edit()
                        .putString("ADDRESS",address);

                Intent jj = new Intent();
                jj.putExtra("name",name);
                setResult(Activity.RESULT_OK,jj);
                finish();
            }
        });
    }
}
