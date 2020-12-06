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


import java.util.Random;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_second, container, false);

        int days = 0;
        for (int i = 0; i < 31; i++){
            if (MainActivity.getDayTracker().charAt(i) == '1'){
                days++;
                String name = "imageView" + Integer.toString(i);
                int resID = getResources().getIdentifier(name,
                        "id", getActivity().getPackageName());
                System.out.println(resID);
                ImageView imgExample = (ImageView) view.findViewById(resID);
                Random rand = new Random();
                int randNum = rand.nextInt(1000);
                if (randNum % 3 == 0){
                    imgExample.setImageResource(R.drawable.fullcactus2);
                }
                else if (randNum % 3 == 1){
                    imgExample.setImageResource(R.drawable.fullcactus3);
                }
                else {
                    imgExample.setImageResource(R.drawable.cactus);
                }
            }
        }


        // Displays the amount of hours
        String totalAmountOfDays = Integer.toString(days);
        String ending = " Total Days";
        if (days == 1)
            ending = " Total Day";
        TextView text = (TextView) view.findViewById(R.id.textview_Progress);
        text.setText(totalAmountOfDays + ending);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}