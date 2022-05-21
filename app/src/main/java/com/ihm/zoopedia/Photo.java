package com.ihm.zoopedia;


import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import java.util.Random;


public class Photo extends AppCompatActivity {
    private Button Retour;
    private Button CaptureImage;
    private TextView Notification;

    private ImageView imageView;

    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private final String Notificatiob_corps="Bravo vous avez pris en photo : ";
    private final String Notification_suricate="Astigmate le suricate";
    private final String Notification_babouin="Emilien le babouin";
    private final String Notification_gazelle="Gisèle la gazelle";
    private final String Notification_dauphin="Poséidon le dauphin";
    private final String Notification_girafe="Antares la girafe";
    private final String Notification_anaconda="Anna l'anaconda";
    private final String Notification_jaguar="Edouard le jaguar";
    private final String Notification_gorille="Achille le gorille ";
    private final String Notification_error="Mince alors, réessayez :)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        CaptureImage = findViewById(R.id.CaptureImage);
        Retour = findViewById(R.id.Retour);

        imageView = findViewById(R.id.imageView);
        Notification = findViewById(R.id.Notification);

        CaptureImage.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();
            }
        });

        Retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), mainScreen.class);
                finish();
            }
        });


    }

    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Bitmap picture = (Bitmap) data.getExtras().get("data");
                this.imageView.setImageBitmap(picture);
                afficherNotification(genererNotification());
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action annulée", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action échouée", Toast.LENGTH_LONG).show();
            }
        }
    }

    private String genererNotification(){
        Random rand = new Random();
        int limit = 60;
        String res = Notification_error;
        int i = rand.nextInt(limit);
        switch (i){
            case 2:
                res = Notificatiob_corps+ Notification_suricate;
                break;
            case 3:
                res = Notificatiob_corps+ Notification_babouin;
                break;
            case 5:
                res = Notificatiob_corps+ Notification_gazelle;
                break;
            case 8:
                res = Notificatiob_corps+ Notification_dauphin;
                break;
            case 13:
                res = Notificatiob_corps+ Notification_girafe;
                break;
            case 21:
                res = Notificatiob_corps+ Notification_anaconda;
                break;
            case 34:
                res = Notificatiob_corps+ Notification_jaguar;
                break;
            case 55:
                res = Notificatiob_corps+ Notification_gorille;
                break;
        }
        return res;
    }

    private void afficherNotification(String message) {

        Notification.setText(message);
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) { }
            public void onFinish() {
                Notification.setText("");
            }
        }.start();
    }
}
