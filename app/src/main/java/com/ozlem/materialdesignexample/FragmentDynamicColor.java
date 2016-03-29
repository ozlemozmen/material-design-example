package com.ozlem.materialdesignexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentDynamicColor extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_dynamic_color, container, false);

        final TextView title1 = (TextView) rootView.findViewById(R.id.title1);
        final TextView title2 = (TextView) rootView.findViewById(R.id.title2);
        final TextView title3 = (TextView) rootView.findViewById(R.id.title3);
        final TextView title4 = (TextView) rootView.findViewById(R.id.title4);
        final TextView title5 = (TextView) rootView.findViewById(R.id.title5);
        final TextView title6 = (TextView) rootView.findViewById(R.id.title6);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.f);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatchVibrant = palette.getVibrantSwatch();
                if (swatchVibrant != null) {
                    title2.setBackgroundColor(swatchVibrant.getRgb());
                    title2.setTextColor(swatchVibrant.getTitleTextColor());
                    title2.setText("palette.getVibrantSwatch");
                    title2.setHeight(swatchVibrant.getPopulation() * 6);
                }

                Palette.Swatch swatchDarkVibrant = palette.getDarkVibrantSwatch();
                if (swatchDarkVibrant != null) {
                    title3.setBackgroundColor(swatchDarkVibrant.getRgb());
                    title3.setTextColor(swatchDarkVibrant.getTitleTextColor());
                    title3.setText("palette.getDarkVibrantSwatch");
                    title3.setHeight(swatchDarkVibrant.getPopulation() * 6);
                }

                Palette.Swatch swatchDarkMutedVibrant = palette.getDarkMutedSwatch();
                if (swatchDarkMutedVibrant != null) {
                    title4.setBackgroundColor(swatchDarkMutedVibrant.getRgb());
                    title4.setTextColor(swatchDarkMutedVibrant.getTitleTextColor());
                    title4.setText("palette.getDarkMutedSwatch");
                    title4.setHeight(swatchDarkMutedVibrant.getPopulation() * 6);
                }

                Palette.Swatch swatchLightMutedVibrant = palette.getLightMutedSwatch();
                if (swatchLightMutedVibrant != null) {
                    title6.setBackgroundColor(swatchLightMutedVibrant.getRgb());
                    title6.setTextColor(swatchLightMutedVibrant.getTitleTextColor());
                    title6.setText("palette.swatchLightMutedVibrant");
                    title6.setHeight(swatchLightMutedVibrant.getPopulation() * 6);
                }

                Palette.Swatch swatchLightVibrant = palette.getLightVibrantSwatch();
                if (swatchLightVibrant != null) {
                    title1.setBackgroundColor(swatchLightVibrant.getRgb());
                    title1.setTextColor(swatchLightVibrant.getTitleTextColor());
                    title1.setText("palette.swatchLightVibrant");
                    title1.setHeight(swatchLightVibrant.getPopulation() * 6);
                }

                Palette.Swatch swatchMuted = palette.getMutedSwatch();
                if (swatchMuted != null) {
                    title5.setBackgroundColor(swatchMuted.getRgb());
                    title5.setTextColor(swatchMuted.getTitleTextColor());
                    title5.setText("palette.swatchMuted");
                    title5.setHeight(swatchMuted.getPopulation() * 6);
                }

            }
        });

        return rootView;
    }


    public FragmentDynamicColor() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

}
