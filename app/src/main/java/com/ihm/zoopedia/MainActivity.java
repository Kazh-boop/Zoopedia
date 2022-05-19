package com.ihm.zoopedia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
        TextView titleNotif = new TextView(this);
        titleNotif.setWidth(LayoutParams.WRAP_CONTENT);
        titleNotif.setHeight(LayoutParams.WRAP_CONTENT);
        titleNotif.setTextAppearance(this, android.R.attr.textAppearanceLarge);
        titleNotif.setText("NOTIFICATIONS");
        layout.addView(titleNotif);
        setContentView(R.layout.activity_main);
    }
}