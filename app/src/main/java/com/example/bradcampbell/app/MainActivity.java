package com.example.bradcampbell.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bradcampbell.R;

public class MainActivity extends AppCompatActivity {
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root, new HelloFragment())
                    .commit();
        }
    }
}
