package com.ozlem.materialdesignexample;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentReveal extends Fragment {

    private View rootView;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_reveal, container, false);

        final Button button = (Button) rootView.findViewById(R.id.f_reveal_button2);
        final Button button1 = (Button) rootView.findViewById(R.id.f_reveal_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cx = (button1.getWidth()) / 2;
                int cy = (button1.getHeight()) / 2;
                float radius = Math.max(button1.getWidth(), button1.getHeight()) * 2.0f;

                Animator reveal = ViewAnimationUtils.createCircularReveal(
                        button, // The new View to reveal
                        cx,      // x co-ordinate to start the mask from
                        cy,      // y co-ordinate to start the mask from
                        0,  // radius of the starting mask
                        radius);   // radius of the final mask
                button.setVisibility(View.VISIBLE);
                button1.setVisibility(View.GONE);
                reveal.setDuration(2000);
                reveal.start();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cx = (button1.getWidth()) / 2;
                int cy = (button1.getHeight()) / 2;
                float radius = Math.max(button1.getWidth(), button1.getHeight()) * 2.0f;

                Animator reveal = ViewAnimationUtils.createCircularReveal(
                        button1, // The new View to reveal
                        cx,      // x co-ordinate to start the mask from
                        cy,      // y co-ordinate to start the mask from
                        0,  // radius of the starting mask
                        radius);   // radius of the final mask
                button1.setVisibility(View.VISIBLE);
                button.setVisibility(View.GONE);
                reveal.setDuration(2000);
                reveal.start();
            }
        });


        return rootView;
    }



    public FragmentReveal() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

}
