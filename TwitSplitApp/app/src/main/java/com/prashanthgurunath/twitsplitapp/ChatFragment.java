package com.prashanthgurunath.twitsplitapp;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ChatFragment extends android.support.v4.app.Fragment {

    private TextView messageTextView;
    private EditText userInputEditText;
    private Button sendButton;
    private String userInputString;
    private CoordinatorLayout coordinatorLayout;

    private AdView mAdView;

    private int spaceCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.chat_home_fragment,container,false);

        // map all variables with their corresponding XML ID's
        messageTextView=v.findViewById(R.id.message_text_view_id);
        userInputEditText=v.findViewById(R.id.user_input_edit_text_id);
        sendButton=v.findViewById(R.id.send_button_id);
        coordinatorLayout = (CoordinatorLayout)v.findViewById(R.id.coordinator_layout_id);

        adMob(v);  // call admob fn to display banner ads
        sendButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                userInputString=userInputEditText.getText().toString().trim();


                if(!userInputString.isEmpty()) {   // check if it is not empty

                    if(nonWhiteSpaceChar(userInputString))
                    {
                        userInputEditText.setError("Message has more than 50 non-whitespace characters.");
                    }
                    else if(count(userInputString)<=50)
                    {
                        displayMessage(userInputString);
                    }
                    else {
                        splitMessage(userInputString);
                    }

                }
                else {
                    userInputEditText.setError("Empty Message. Pls enter a text");   // input is empty
                }
            }
        });


        return v;
    }


    private void adMob(View v) {

        MobileAds.initialize(getActivity(),"ca-app-pub-9067547029538739/6176576790");  // from admobs account

        mAdView=new AdView(getActivity());
        mAdView = v.findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("903A70A3D439E256BAED43E65A79928E")
                .build();


        mAdView.setAdListener(new AdListener()

                              {
                                  @Override
                                  public void onAdLoaded()
                                  {

                                  }

                                  @Override
                                  public void onAdClosed() {
                                      //                Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
                                  }

                                  @Override
                                  public void onAdFailedToLoad(int errorCode) {
                                      //                Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
                                  }

                                  @Override
                                  public void onAdLeftApplication() {
                                      //              Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
                                  }

                                  @Override
                                  public void onAdOpened() {
                                      super.onAdOpened();
                                  }

                              }
        );

        mAdView.loadAd(adRequest);

    }
    public int count(String msg)   // returns length of the string
    {

        return msg.length();
    }

    public boolean nonWhiteSpaceChar(String msg)
    {
        // this function is to check if the string has a set of non white space characters>50

        spaceCount = 0;
        for(int j= 0; j < msg.length(); j++) {
            if(Character.isWhitespace(msg.charAt(j)))
            {
                spaceCount++;
            }
        }

        if(spaceCount==0 && msg.length()>50)  // string has more than 50 non white space characters
        {
            return true;
        }
        else {
            return false;
        }

    }


        public int getSpaceCount(String userInputString)
        {
            nonWhiteSpaceChar(userInputString);
            return spaceCount;
        }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void splitMessage(String msg) {

        List<String> results = new ArrayList<String>();
        int i = 0;
        int k=50;

        for (;;)
        {
            // this loop is only till we reach end of data
            if (i >= msg.length())
            {
                break;
            }

            int index = i + k;
            // consider k characters from [i, index-1]


            if (index >= msg.length())
            {
                // end of msg
                // index is outside msg

                int endIndex=msg.length()-1;

                results.add(msg.substring(i, endIndex+1));

                break;
            }
            else {


                // we know that index < data.size(), we can check if it is a space

                if (isSpace(msg.charAt(index)))   // check if msg[index] is a space

                {

                    results.add(msg.substring(i, index - 1));

                    i = index; // to include the space in the next line
                }
                else
                {
                    // to find a space from behind
                    boolean isValidInput = false;
                    for (int j = index-1; j >= i; --j)
                    {
                        if (isSpace(msg.charAt(j)  ) )
                        {
                            results.add(msg.substring(i, j+1));

                            i = j + 1;
                            isValidInput = true;
                            break;
                        }
                    }


                    if (!isValidInput)   // size>k
                    {
                        Toast.makeText(getActivity(),
                                "Error: Invalid input, string must have a space",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

        }  // end of for loop


        // display
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        for(int p=0;p<results.size();++p)
        {
            messageTextView.append(
                    Html.fromHtml("<p><b>You: </b> " + (p+1)+"/"+results.size() + " "
                            +results.get(p) + " <i> [ "+simpleDateFormat.format(date)+" ] </i>" ) );


            userInputEditText.setText("");  // to clear editText data after message is sent

            showSnackBar();

        }


    } // end of split message function()

    public boolean isSpace(char c) {  // checks if character is a space or not

        if(c==' ')
        {
            return true;
        }
        else
            return false;
    }

    public void displayMessage(final String userInputString)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();


        messageTextView.append(
                Html.fromHtml("<p><b>You: </b> "
                        + userInputString + " <i> [ "+simpleDateFormat.format(date)+" ] </i>" ) );


        userInputEditText.setText("");  // to clear editText data after message is sent

        showSnackBar();


    }  // end of displayMessage()

    private void showSnackBar()     // to display "clear all" snackbar
    {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Clear All Messages", Snackbar.LENGTH_LONG)
                .setAction("Clear", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        messageTextView.setText("");
                        userInputEditText.setText("");
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Messages Deleted. List is Empty", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();
    }



}  // end of fragment class
