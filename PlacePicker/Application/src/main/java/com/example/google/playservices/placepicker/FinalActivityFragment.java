package com.example.google.playservices.placepicker;

import android.app.Fragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * A placeholder fragment containing a simple view.
 */
public class FinalActivityFragment extends Fragment {
    private TimePicker timePicker1;
    private int mHour;
    private  int mMinute;
    public FinalActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView2 = inflater.inflate(R.layout.fragment_final, container, false);
        final Integer total =  getActivity().getIntent().getExtras().getInt("total");
       // Log.d("total",total);
        final Button button = (Button) rootView2.findViewById(R.id.button2);
        timePicker1 = (TimePicker) rootView2.findViewById(R.id.timePicker);

         TimePickerDialog.OnTimeSetListener mTimeSetListener =
                new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker timePicker1, int hourOfDay, int minute) {
                        mHour = hourOfDay;
                        mMinute = minute;
                        //updateDisplay();
                    }
                };

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ReviewActivity.class)
                        .putExtra("hello",total)
                        .putExtra("hour",mMinute);
                startActivity(intent);
            }
        });
        return rootView2;
    }


}
