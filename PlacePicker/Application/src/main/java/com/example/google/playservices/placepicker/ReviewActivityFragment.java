package com.example.google.playservices.placepicker;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        final TextView textView6 = (TextView) rootView3.findViewById(R.id.textView6);
        final Button button = (Button) rootView3.findViewById(R.id.button3);
        final TextView textView8 = (TextView) rootView3.findViewById(R.id.textView8);
        Integer hour = getActivity().getIntent().getExtras().getInt("hour");
        Integer minute = getActivity().getIntent().getExtras().getInt("minute");
        final Integer total = getActivity().getIntent().getExtras().getInt("total");

        textView6.setText(hour.toString()+":"+minute.toString());
        textView8.setText( "  $  "  +  total.toString());

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class)
                        .putExtra("total",total.toString());
                startActivity(intent);
            }
        });

        return rootView3;
    }


}
