package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mEtPhoneNumber = findViewById(R.id.enter_phone_number);
        EditText mEtURL = findViewById(R.id.url_id);
        EditText mEtEmailAddress = findViewById(R.id.email_address);
        EditText mEtEmailSubject = findViewById(R.id.email_subject);
        EditText mEtEmailBody = findViewById(R.id.email_body);

        Button mBtnCall = findViewById(R.id.call_button);
        Button mBtnURL = findViewById(R.id.url_button);
        Button mBtnEmail = findViewById(R.id.email_btn_send);

        mBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = mEtPhoneNumber.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+phoneNumber));
                startActivity(callIntent);
            }
        });

        mBtnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = mEtURL.getText().toString();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(url));
                startActivity(browserIntent);
            }
        });

        mBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = mEtEmailAddress.getText().toString();
                String emailSubject = mEtEmailBody.getText().toString();
                String emailBody = mEtEmailBody.getText().toString();

                String[] multiAddress = emailAddress.split(",");

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, multiAddress);
                emailIntent.setType("message/rfc822");
                startActivity(emailIntent);
            }
        });
    }

}