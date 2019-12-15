package com.example.note;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    /**Resource ID for the background color for this list or words */
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        //Here, we initialize the ArrayAdapter's internal storage for the context and the list,
        // the second argument is used when the ArrayAdapter is populating a single TextView
        // Because this is a custom adapter for two TextView and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0
        super(context, 0, words);
        mColorResourceId =  colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the xisting view is being resused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView ==  null){
            listItemView =  LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        // Get the {@Link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Version name from the current AndroidFlavor object and set this text on the vNameText
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the Version name from the current AndroidFlavor object and set this text on the vNameText
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()) {
            // Set the ImageView to the image resource  specified in the current Word
            imageView.setImageResource(currentWord.getImageResourceId());

            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            //Otherwise hde the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //FInd the color that resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the text contaoner VIew
        textContainer.setBackgroundColor(color);

        //Return the whole list item layout (containing 2 TextView and an ImageView) so that i
        return listItemView;
    }
}
