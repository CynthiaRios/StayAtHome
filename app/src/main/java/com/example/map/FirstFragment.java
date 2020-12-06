package com.example.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,

            Bundle savedInstanceState

    ) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);
        ImageView imgExample = (ImageView) view.findViewById(R.id.imageViewer);
        // FIXME: Global Variable for time
        int time = 25;

        if (time > 24)
            time = 24;
        if (time < 0)
            time = 0;

        // FIXME: Fix images
        if (time <= 4) {
            imgExample.setImageResource(R.drawable.cactus1);
        }
        else if (time <= 8) {
            imgExample.setImageResource(R.drawable.cactus2);
        }
        else if (time <= 12) {
            imgExample.setImageResource(R.drawable.cactus3);
        }
        else if (time <= 16) {
            imgExample.setImageResource(R.drawable.cactus4);
        }
        else if (time <= 20){
            imgExample.setImageResource(R.drawable.cactus5);
        }
        else {
            imgExample.setImageResource(R.drawable.cactus6);

            // Adds tree to monthly view
            Calendar cal = Calendar.getInstance();
            int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

            char[] dayTracker = MainActivity.getDayTracker().toCharArray();
            dayTracker[dayOfMonth] = '1';
            MainActivity.setDayTracker(String.valueOf(dayTracker));
        }

        // Displays the amount of hours
        String totalAmountOfHours = Integer.toString(time);
        String ending = " Hours";
        if (time == 1)
            ending = " Hour";
        TextView text = (TextView) view.findViewById(R.id.textview_Progress);
        text.setText(totalAmountOfHours + ending);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}