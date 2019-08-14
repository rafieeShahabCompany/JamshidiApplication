package com.shahab.jamshidiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick = findViewById(R.id.btnClick);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout Drawer = findViewById(R.id.Drawer);
                Drawer.openDrawer(Gravity.RIGHT);
            }
        });

        RecyclerView recycler = findViewById(R.id.recycler);

        List<String> menu = new ArrayList<>();
        menu.add("Profile");
        menu.add("Call");
        menu.add("Season");

        DesignAdapter adapter = new DesignAdapter(menu);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                RecyclerView.VERTICAL, false));








    }
}
