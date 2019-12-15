package com.example.note;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SHAJIB-PC on 9/9/2019.
 */

class ListNewsAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;

    public ListNewsAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ListNewsViewHolder holder = null;
        if (convertView == null) {
            holder = new ListNewsViewHolder();
            convertView = LayoutInflater.from(activity).inflate(
                    R.layout.list_row, parent, false);
            holder.galleryImage = (ImageView) convertView.findViewById(R.id.galleryImage);
            holder.full_name = (TextView) convertView.findViewById(R.id.full_name);
            holder.username = (TextView) convertView.findViewById(R.id.username);
            holder.bio = (TextView) convertView.findViewById(R.id.bio);
            holder.galleryImage = (ImageView) convertView.findViewById(R.id.galleryImage);

            convertView.setTag(holder);
        } else {
            holder = (ListNewsViewHolder) convertView.getTag();
        }
        holder.galleryImage.setId(position);
        holder.full_name.setId(position);
        holder.username.setId(position);
        holder.bio.setId(position);
        holder.galleryImage.setId(position);


        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        try{
            holder.full_name.setText(song.get(InstagramActivity.KEY_NAME));
            holder.username.setText(song.get(InstagramActivity.KEY_USERNAME));
            holder.bio.setText(song.get(InstagramActivity.KEY_BIO));


            if(song.get(InstagramActivity.KEY_URLTOIMAGE).toString().length() < 5)
            {
                holder.galleryImage.setVisibility(View.GONE);
            }else{
                Picasso.get()
                        .load(song.get(InstagramActivity.KEY_URLTOIMAGE))
                        .resize(300, 200)
                        .centerCrop()
                        .into(holder.galleryImage);
            }
        }catch(Exception e) {}
        return convertView;
    }

}

class ListNewsViewHolder {
    ImageView galleryImage;
    TextView full_name, username, bio;
}
