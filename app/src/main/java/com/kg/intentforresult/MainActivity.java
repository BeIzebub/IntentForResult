package com.kg.intentforresult;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.content.Intent.EXTRA_TEXT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_INPUT = 10001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        TextView textView = new TextView(this);
        layout.addView(textView);
        setContentView(layout);

        findViewById(R.id.explicitBtn).setOnClickListener(this);
        findViewById(R.id.implicitBtn).setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_INPUT){
            if(resultCode == RESULT_OK){
                Log.i("asdasd", "onActivityResult: " + data.getStringExtra(EXTRA_TEXT));
            } else {
                Log.e("asdasd", "onActivityResult: failed");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.explicitBtn:
                Intent explicitIntent =
                        new Intent(MainActivity.this, InputAncivity.class);
                explicitIntent.putExtra(Intent.EXTRA_TEXT, "hello");
                startActivityForResult(explicitIntent, REQUEST_CODE_INPUT);
                break;
            case R.id.implicitBtn:
                Intent implicitIntent = new Intent();

                implicitIntent.setAction(Intent.ACTION_SENDTO);
                implicitIntent.setData(Uri.parse("mailto:example@gmail.com"));

                implicitIntent.putExtra(Intent.EXTRA_SUBJECT, "subjetct");
                implicitIntent.putExtra(EXTRA_TEXT, "Dear Mr. A,\n\nHello");

                startActivity(Intent.createChooser(implicitIntent, "Send text"));
                break;

        }
    }
}
