package com.example.email_send;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText emailTo, emailSubject, emailBody;
    Button btn;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.email_btn);
        emailTo =  findViewById(R.id.email_to);
        emailSubject =  findViewById(R.id.email_subject);
        emailBody =  findViewById(R.id.email_msg);
        imageView = findViewById(R.id.img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendEmail(emailTo.getText().toString(),emailSubject.getText().toString(),emailBody.getText().toString());
                sendImage(emailTo.getText().toString(),emailSubject.getText().toString(),emailBody.getText().toString());
            }
        });
    }

//    private void sendEmail(String email,String subject,String body)
//    {
//
//        Intent i = new Intent(Intent.ACTION_SEND);
//        i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
//        i.putExtra(Intent.EXTRA_SUBJECT,subject);
//        i.putExtra(Intent.EXTRA_TEXT,body);
//        i.setType("message/rfc822");
//        startActivity(Intent.createChooser(i,"send email"));
//
////        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
////        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
////        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
////        intent.putExtra(Intent.EXTRA_TEXT,body);
////        intent.setType("text/plain");
////        startActivity(Intent.createChooser(intent,"Send email"));
//    }

    private void sendImage(String email,String subject,String body)
    {
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        String bitMapPath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);

        Intent i =  new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_STREAM,Uri.parse(bitMapPath));

        i.setType("image/png");
        startActivity(Intent.createChooser(i,"share via"));
    }
}

// i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
//         i.putExtra(Intent.EXTRA_SUBJECT,subject);
//         i.putExtra(Intent.EXTRA_TEXT,body);
//         i.setType("message/rfc822");