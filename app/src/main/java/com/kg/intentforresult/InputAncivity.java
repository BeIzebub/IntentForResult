package com.kg.intentforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

public class InputAncivity extends AppCompatActivity {

    private TextView textView;
    private EditText input;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        String text = getIntent().getStringExtra(Intent.EXTRA_TEXT);

        textView = findViewById(R.id.textView);
        textView.setText(text);

        input = findViewById(R.id.inputEditText);
    }

    @Override
    public void onBackPressed() {
        if(TextUtils.isEmpty(input.getText().toString())){
            setResult(RESULT_CANCELED);
        }
        else {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(Intent.EXTRA_TEXT, input.getText().toString());
            setResult(RESULT_OK, resultIntent);
        }
        super.onBackPressed();
    }
}
