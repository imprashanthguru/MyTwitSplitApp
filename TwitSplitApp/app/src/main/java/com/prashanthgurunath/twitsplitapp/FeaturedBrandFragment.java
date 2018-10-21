package com.prashanthgurunath.twitsplitapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class FeaturedBrandFragment extends android.support.v4.app.Fragment {


    private ImageView spritImageView, calvinImageView, superDryImageView;
    private ImageView reebokImageView,burtonImageView, riverIslandImageView;

    private ImageView blancImageView,mangoImageView, riverIslandWomenImageView;
    private ImageView superDryWomenImageView, zaliaImageView,annaSuiImageView;


    private Intent openZaloraAppIntent,openBrowserIntent;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.featured_brands_fragment,container,false);

// assign all ImageView Objects to corresponsing XML ID's

        spritImageView=v.findViewById(R.id.sprit_image_view_id);
        calvinImageView=v.findViewById(R.id.calvin_image_view_id);
        superDryImageView=v.findViewById(R.id.super_dry_image_view_id);
        reebokImageView=v.findViewById(R.id.reebok_image_view_id);
        burtonImageView=v.findViewById(R.id.burton_image_view_id);
        riverIslandImageView=v.findViewById(R.id.river_island_image_view_id);
        blancImageView=v.findViewById(R.id.blanc_image_view__id);
        mangoImageView=v.findViewById(R.id.mango_image_view_id);
        riverIslandWomenImageView=v.findViewById(R.id.river_island_women_image_view_id);
        superDryWomenImageView=v.findViewById(R.id.super_dry_women_image_view_id);
        zaliaImageView=v.findViewById(R.id.zalia_image_view_id);
        annaSuiImageView=v.findViewById(R.id.anna_sui_image_view_id);




        spritImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));

                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.sprit_web_link)));
                    startActivity(openBrowserIntent);

            }
        });
        calvinImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));

                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.calvin_web_link)));
                    startActivity(openBrowserIntent);
            }
        });

        superDryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));

                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.super_dry_men_web_link)));
                    startActivity(openBrowserIntent);
                }
        });
        reebokImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));

                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.reebok_web_link)));
                    startActivity(openBrowserIntent);
                }
        });

        burtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));

                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.burton_web_link)));
                    startActivity(openBrowserIntent);
            }
        });
        riverIslandImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.river_island_men_web_link)));
                    startActivity(openBrowserIntent);
                }
        });

        blancImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.blanc_web_link)));
                    startActivity(openBrowserIntent);
                }
        });

        mangoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.mango_web_link)));
                    startActivity(openBrowserIntent);
                }
        });

        riverIslandWomenImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));

                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.river_island_women_web_link)));
                    startActivity(openBrowserIntent);
            }
        });

        zaliaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.zalia_web_link)));
                    startActivity(openBrowserIntent);
                }
        });

        superDryWomenImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.super_dry_women_web_link)));
                    startActivity(openBrowserIntent);
                }
        });

        annaSuiImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                    openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(getResources().getString(R.string.anna_sui_web_link)));
                    startActivity(openBrowserIntent);
            }
        });





        return v;
    } // end of onCreateView

}  // end of class
