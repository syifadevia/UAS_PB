package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View){
                openSearch();
            }
        });
    }

    public void openSearch(){
        EditText nameField = (EditText) findViewById(R.id.searchField);
        Editable nameEditable = nameField.getText();
        String query = nameEditable.toString();

        Intent intent = new Intent(this, InstagramActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }

    public void biodata(View view) {
        Intent intent = new Intent(MainActivity.this, biodata.class);
        startActivity(intent);
    }

    public void kenangan(View view) {
        Intent intent = new Intent(MainActivity.this, kenangan.class);
        startActivity(intent);
    }
    public void note(View view) {
        Intent intent = new Intent(MainActivity.this, InstagramActivity.class);
        startActivity(intent);
    }



    public void feed(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:faasyf@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "ingatkan saya hari ini !!");
        if (intent.resolveActivity(getPackageManager()) !=null) {
            startActivity(intent);
        }
    }
}
