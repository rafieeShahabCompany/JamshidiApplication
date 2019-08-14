package com.shahab.jamshidiapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Review extends AppCompatActivity {

    TextView txtWellcome = findViewById(R.id.txtWellcome);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        final EditText edtName = findViewById(R.id.edtName);
        final EditText edtFamily = findViewById(R.id.edtFamily);
        final EditText edtAge = findViewById(R.id.edtAge);
        final EditText edtPhone = findViewById(R.id.edtPhone);
        final EditText edtAddress = findViewById(R.id.edtAddress);
        Button btnReview = findViewById(R.id.btnReview);

        String Information = PreferenceManager.getDefaultSharedPreferences(Review.this)
                .getString("Name", "Unknown");
        txtWellcome.setText("Wellcom " + Information);

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Review.this, Confirm.class);

                String Name = edtName.getText().toString();
                String Family = edtFamily.getText().toString();
                String Age = edtAge.getText().toString();
                String Phone = edtPhone.getText().toString();
                String Address = edtAddress.getText().toString();

                i.putExtra("name", Name);
                i.putExtra("family", Family);
                i.putExtra("age", Age);
                i.putExtra("phone", Phone);
                i.putExtra("address", Address);
                startActivityForResult(i, 2000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2000) {
            if (resultCode == Activity.RESULT_OK) {
                String message = data.getStringExtra("name");
                txtWellcome.setText("Wellcome " + message + "!");

            }
        }
    }

}