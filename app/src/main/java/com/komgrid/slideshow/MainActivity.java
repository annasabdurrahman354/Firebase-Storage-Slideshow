package com.komgrid.slideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ArrayList<String> NIM = new ArrayList<>();
    private Button btnM0519017;
    private Button btnM0519024;
    private Button btnM0519044;
    private Button btnM0519047;
    private Button btnN0121632;
    private Button btnN0121633;
    private String nim = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NIM.add("M0519017");
        NIM.add("M0519024");
        NIM.add("M0519044");
        NIM.add("M0519047");
        NIM.add("N0121632");
        NIM.add("N0121633");

        btnM0519017 = findViewById(R.id.btnM0519017);
        btnM0519024 = findViewById(R.id.btnM0519024);
        btnM0519044 = findViewById(R.id.btnM0519044);
        btnM0519047 = findViewById(R.id.btnM0519047);
        btnN0121632 = findViewById(R.id.btnN0121632);
        btnN0121633 = findViewById(R.id.btnN0121633);

        Intent i = new Intent(MainActivity.this, SlideshowActivity.class);

        btnM0519017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nim ="M0519017";
                i.putExtra("nim",nim);
                startActivity(i);
            }
        });
        btnM0519024.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nim ="M0519024";
                i.putExtra("nim",nim);
                startActivity(i);
            }
        });
        btnM0519044.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nim ="M0519044";
                i.putExtra("nim",nim);
                startActivity(i);
            }
        });
        btnM0519047.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nim ="M0519047";
                i.putExtra("nim",nim);
                startActivity(i);
            }
        });
        btnN0121632.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nim ="N0121632";
                i.putExtra("nim",nim);
                startActivity(i);
            }
        });
        btnN0121633.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nim ="N0121633";
                i.putExtra("nim",nim);
                startActivity(i);
            }
        });

    }
}