package com.example.android.tourguideapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class HeritageFragment extends Fragment {

    public HeritageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        // Create and setup the {@link AudioManager} to request audio focus

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(getString(R.string.h_one_Place),getString(R.string.h_one_address) , getString(R.string.h_time), R.drawable.one));
        words.add(new Word(getString(R.string.h_two_Place),getString(R.string.h_two_address) , getString(R.string.h_time), R.drawable.two));
        words.add(new Word(getString(R.string.h_three_Place),getString(R.string.h_three_address) , getString(R.string.h_time), R.drawable.three));
        words.add(new Word(getString(R.string.h_four_Place),getString(R.string.h_four_address) , getString(R.string.h_time), R.drawable.four));
        words.add(new Word(getString(R.string.h_five_Place),getString(R.string.h_five_address) , getString(R.string.h_time), R.drawable.five));
        words.add(new Word(getString(R.string.h_six_Place),getString(R.string.h_six_address) , getString(R.string.h_time), R.drawable.six));
        words.add(new Word(getString(R.string.h_seven_Place),getString(R.string.h_seven_address) , getString(R.string.h_time), R.drawable.seven));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdopter adapter = new WordAdopter(getActivity(), words, R.color.category_heritage);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Word word = words.get(position);


            }
        });

        return rootView;
    }


}
