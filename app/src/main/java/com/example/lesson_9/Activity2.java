package com.example.lesson_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    protected TextView tvA2;
    protected EditText etA2;
    protected Button bottonA2;
    protected Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tvA2 = findViewById(R.id.tvA2);
        etA2 = findViewById(R.id.etA2);
        bottonA2 = findViewById(R.id.buttonA2);


        tvA2.setText("");
        i = getIntent();
        if (i != null) {
            tvA2.setText(i.getStringExtra("key_1"));
            Log.d("myLog", "Result String: " + i.getStringExtra("key_1"));
            Log.d("myLog", "Result Int: " + i.getIntExtra("key_2", 0));
            Log.d("myLog", "Result Boolean: " + i.getBooleanExtra("key_3", false));
        }

    }

    public void onClickA2(View view) {
        i.putExtra("sentence", etA2.getText().toString());
        setResult(RESULT_OK, i);
        finish();

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}