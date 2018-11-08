package com.example.nordwest.my_uni_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    TextView profileName, profileSt_ID, groupProfile, emailProfile;

    public static String EMAIL_KEY = "EMAIL_KEY";
    private CircleImageView profilePhoto;

    private View.OnClickListener OnCircleImageViewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*the view will set mentioned layout on the whole display when the app will launch */

        setContentView(R.layout.activity_profile);


        profileName = findViewById(R.id.userProfileName);
        profilePhoto = findViewById(R.id.profile_image);
        profileSt_ID = findViewById(R.id.studentProfileID);
        groupProfile = findViewById(R.id.groupProfile);
        emailProfile = findViewById(R.id.studentEmailProfile);


        /*Create a bundle to get the data sent by the intent*/
        Bundle bundle = getIntent().getExtras();
        //save sent data in their corresponding fields
        emailProfile.setText(bundle.getString(EMAIL_KEY));
        profilePhoto.setOnClickListener(OnCircleImageViewClickListener);


    }
}
