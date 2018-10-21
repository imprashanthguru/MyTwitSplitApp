package com.prashanthgurunath.twitsplitapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

public class ContactUsFragment extends android.support.v4.app.Fragment  {


    private CardView singaporeCardView, philippinesCardView,hongKongCardView;
    private CardView indonesiaCardView, malaysiaCardView, bruneiCardView,taiwanCardView;

    private TextView placeName,websiteLink, customerCareEmail , phoneNumber;

    private Intent websiteIntent, customerCareIntent, phoneNumberIntent;
    private Intent fbIntent, instagramIntent, twitterIntent, youtubeIntent;

    private CircularImageView fbCircularImageView, instaCircularImageView, twitterCircularImageView, youtubeCircularImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.contact_us_fragment,container,false);

        singaporeCardView=v.findViewById(R.id.singapore_card_view_id);
        philippinesCardView=v.findViewById(R.id.philippines_card_view_id);
        hongKongCardView=v.findViewById(R.id.hong_kong_card_view_id);
        indonesiaCardView=v.findViewById(R.id.indonesia_card_view_id);
        malaysiaCardView=v.findViewById(R.id.malaysia_card_view_id);
        bruneiCardView=v.findViewById(R.id.brunei_card_view_id);
        taiwanCardView=v.findViewById(R.id.taiwan_card_view_id);



        placeName=v.findViewById(R.id.place_name_contact_us_id);
        websiteLink=v.findViewById(R.id.website_name_contact_us_id);
        customerCareEmail=v.findViewById(R.id.customer_care_contact_us_id);
        phoneNumber=v.findViewById(R.id.phone_number_contact_us_id);

        fbCircularImageView=v.findViewById(R.id.facebook_image_view_id);
        instaCircularImageView=v.findViewById(R.id.instagram_image_view_id);
        twitterCircularImageView=v.findViewById(R.id.twitter_image_view_id);
        youtubeCircularImageView=v.findViewById(R.id.youtube_image_view_id);


        singaporeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));

                placeName.setText("Singapore");
                websiteLink.setText(R.string.sg_website);
                customerCareEmail.setText(R.string.sg_customer_care);
                phoneNumber.setText(R.string.sg_phone_num);
            }
        });
        philippinesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                placeName.setText("Philippines");
                websiteLink.setText(R.string.ph_website);
                customerCareEmail.setText(R.string.ph_customer_care);
                phoneNumber.setText(R.string.ph_phone_num);
            }
        });

        hongKongCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                placeName.setText("Hong Kong");
                websiteLink.setText(R.string.hk_website);
                customerCareEmail.setText(R.string.hk_customer_care);
                phoneNumber.setText(R.string.hk_phone_num);
            }
        });

        indonesiaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                placeName.setText("Indonesia");
                websiteLink.setText(R.string.indonesia_website);
                customerCareEmail.setText(R.string.indonesia_customer_care);
                phoneNumber.setText(R.string.indonesia_phone_num);
            }
        });

        malaysiaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                placeName.setText("Malaysia");
                websiteLink.setText(R.string.malaysia_website);
                customerCareEmail.setText(R.string.malaysia_customer_care);
                phoneNumber.setText(R.string.malaysia_phone_num);
            }
        });

        bruneiCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                placeName.setText("Brunei");
                websiteLink.setText(R.string.brunei_website);
                customerCareEmail.setText(R.string.brunei_customer_care);
                phoneNumber.setText(R.string.brunei_phone_num);
            }
        });
        taiwanCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                placeName.setText("Taiwan");
                websiteLink.setText(R.string.tw_website);
                customerCareEmail.setText(R.string.tw_customer_care);
                phoneNumber.setText(R.string.tw_phone_num);
            }
        });

        websiteLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                websiteIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(websiteLink.getText().toString()));
                startActivity(websiteIntent);
            }
        });

        customerCareEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
               customerCareIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",customerCareEmail.getText().toString(), null));
                customerCareIntent.putExtra(Intent.EXTRA_SUBJECT, "Query");
                customerCareIntent.putExtra(Intent.EXTRA_TEXT, "Mail to Zalora Customer Care");
                getActivity().startActivity(Intent.createChooser(customerCareIntent, "Sending Email"));
            }
        });

        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                phoneNumberIntent = new Intent(Intent.ACTION_DIAL);
                phoneNumberIntent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
                getActivity().startActivity(phoneNumberIntent);
            }
        });



        fbCircularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                fbIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.zalora_facebook_link)));
                startActivity(fbIntent);

            }
        });
        instaCircularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                instagramIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.zalora_instagram_link)));
                startActivity(instagramIntent);

            }
        });
        twitterCircularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                twitterIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.zalora_twitter_link)));
                startActivity(twitterIntent);
            }
        });
        youtubeCircularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_onclick_anim));
                youtubeIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.zalora_youtube_link)));
                startActivity(youtubeIntent);

            }
        });


        return v;
    }
}
