package com.example.note;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class InstagramActivity extends AppCompatActivity {

    String API_KEY = "s3kLRhzHdJJSXVfNHxivWuBFN"; // ### YOUE NEWS API HERE ###
    String ID = "instagram"; // Other news source code at: https://newsapi.org/sources
    ListView listNews;
    ProgressBar loader;

    ArrayList<HashMap<String, String>> dataList = new ArrayList<>();
    static final String KEY_NAME = "full_name";
    static final String KEY_URLTOIMAGE = "profile_pict";
    static final String KEY_USERNAME = "username";
    static final String KEY_BIO = "bio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        listNews = findViewById(R.id.listNews);
        loader = findViewById(R.id.loader);
        listNews.setEmptyView(loader);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle!= null){
            String query = (String) bundle.get("query");
            ID = query;
        }


        if (Function.isNetworkAvailable(getApplicationContext())) {
            DownloadNews newsTask = new DownloadNews();
            newsTask.execute();
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }

    }


    class DownloadNews extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() { super.onPreExecute(); }

        protected String doInBackground(String... args) {
            String xml = Function.excuteGet("http://api.farzain.com/ig_profile.php?id=" + ID + "&apikey=" + API_KEY);
            return xml;
        }

        @Override
        protected void onPostExecute(String xml) {

            if (xml.length() > 10) { // Just checking if not empty

                try {
                    JSONObject jsonResponse = new JSONObject(xml);
                    JSONObject object = jsonResponse.getJSONObject("info");

                        HashMap<String, String> map = new HashMap<>();
                        map.put(KEY_NAME, object.getString(KEY_NAME));
                        map.put(KEY_URLTOIMAGE, object.getString(KEY_URLTOIMAGE));
                        map.put(KEY_USERNAME, object.getString(KEY_USERNAME));
                        map.put(KEY_BIO, object.getString(KEY_BIO));
                        dataList.add(map);

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Unexpected error", Toast.LENGTH_SHORT).show();
                }

                ListNewsAdapter adapter = new ListNewsAdapter(InstagramActivity.this, dataList);
                listNews.setAdapter(adapter);

            } else {
                Toast.makeText(getApplicationContext(), "No news found", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
