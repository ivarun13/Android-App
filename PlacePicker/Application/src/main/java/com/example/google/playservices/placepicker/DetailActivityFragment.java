package com.example.google.playservices.placepicker;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    int bprice =  2;
    int sprice =  4;
    int fries =   3;
    int afries =  5;
    int bcount =  0;
    int scount =  0;
    int fcount =  0;
    int afcount = 0;
    int total =   0;
    String s1;
    String s2;
    String s3;
    String s4;

    ArrayAdapter<String> mForecastAdapter;
    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        String key = getActivity().getIntent().getExtras().getString("key");

       if(key.equals("In-N-Out Burger"))
       {
           s1 = "burger"; s2 = "Shake"; s3 = "  Fries"; s4 = " Afries";
       }
        else if(key.equals("Pizza Hut"))
       {
           s1 = "Cheese"; s2 = "Bacon"; s3 = "   BBQ"; s4 = " Italian";
       }
       final String[] data = {
                s1+"                "  +bprice+    "                  "+ bcount ,
                s2+"                 "+ sprice    +"                  "+ scount ,
                s3+"                 "+ fries   +"                  "+ fcount ,
                s4+"                "+  afries   +"                  "+ afcount,
               "TOTAL                             " + total
        };



        final List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));


        // Now that we have some dummy forecast data, create an ArrayAdapter.
        // The ArrayAdapter will take data from a source (like our dummy forecast) and
        // use it to populate the ListView it's attached to.
        mForecastAdapter =
                new ArrayAdapter<String>(
                        getActivity(), // The current context (this activity)
                        R.layout.list_item_forecast, // The name of the layout ID.
                        R.id.list_item_forecast_textview, // The ID of the textview to populate.
                        weekForecast);

        final ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        final Button button = (Button) rootView.findViewById(R.id.button);
        listView.setAdapter(mForecastAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                   String forecast = mForecastAdapter.getItem(position);
                if(position == 0)
                {
                    bcount = bcount + 1;

                    weekForecast.set(0,s1+"                "+bprice    +"                  "+ bcount);
                    ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
                    Toast.makeText(getActivity(),s1+ " added",Toast.LENGTH_SHORT).show();
                }
                if(position == 1)
                {
                    scount = scount + 1;

                    weekForecast.set(1,s2+"                 "+sprice    +"                  "+ scount);
                    ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
                    Toast.makeText(getActivity(),s2 + " added",Toast.LENGTH_SHORT).show();
                }
                if(position == 2)
                {
                    fcount = fcount + 1;

                    weekForecast.set(2,s3+"                 "+fries     +"                  "+ fcount);
                    ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
                    Toast.makeText(getActivity(), s3 + " added",Toast.LENGTH_SHORT).show();
                }
                if(position == 3)
                {
                    afcount = afcount + 1;

                    weekForecast.set(3, s4+"                "+afries    +"                  "+ afcount);
                    ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
                    Toast.makeText(getActivity(),s4 +" added",Toast.LENGTH_SHORT).show();
                }
                total = (bprice*bcount)+(sprice*scount)+(fries*fcount)+(afries*afcount);
                weekForecast.set(4,"TOTAL                                    "+total
                );
            }
        });
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),FinalActivity.class)
                        .putExtra("total",total);
                startActivity(intent);

//                Intent data = new Intent(getActivity(),MainActivity.class)
//                        .putExtra("Burger",bcount)
//                        .putExtra("Shake",scount)
//                        .putExtra("Fries",fcount)
//                        .putExtra("Afries",afcount);
//                startActivity(data);
            }
        });

        return rootView;

    }
}
