package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by deepak on 3/24/2017.
 */

public class WordAdopter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdopter(Activity context, ArrayList<Word> words, int ColorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId= ColorResourceId;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView placeNameTextView = (TextView) listItemView.findViewById(R.id.placeName_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        placeNameTextView.setText(currentWord.getPlaceName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        addressTextView.setText(currentWord.getAddress());

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        timeTextView.setText(currentWord.getTime());

        ImageView defaultImageView = (ImageView) listItemView.findViewById(R.id.object_image_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView

        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            defaultImageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            defaultImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            defaultImageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
