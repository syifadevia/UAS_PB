package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class kenangan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kenangan);
    }

    public void MainActivity(View view) {
        Intent intent = new Intent(kenangan.this, MainActivity.class);
        startActivity(intent);
    }
}
