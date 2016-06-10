package com.example.google.playservices.placepicker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ReviewActivityFragment extends Fragment {

    public ReviewActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView3 = inflater.inflate(R.layout.fragment_review, container, false);
        final TextView textView = (TextView) rootView3.findViewById(R.id.textView);
        Integer Item = getActivity().getIntent().getExtras().getInt("hello");
        textView.setText(Item.toString());

        return rootView3;
    }
}
