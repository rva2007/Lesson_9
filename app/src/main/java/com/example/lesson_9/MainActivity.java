package com.example.lesson_9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    "Hi, write down a sentence with a few repeated words"

/*
    There are apple trees in the apple orchard. The apple goes to the production of apple juice.
    There are apple trees in the apple orchard. The apple goes to the production of apple juice.
    There are apple trees in the apple orchard. The apple goes to the production of apple juice.
    There are apple trees in the apple orchard. The apple goes to the production of apple juice.
    There are apple trees in the apple orchard. The apple goes to the production of apple juice.

 */

    public static final int SENTENCE = 0;
    public static final int SENTENCE_1 = 1;
    protected String mes;
    protected Intent i;
    protected TextView tvMain;
    protected TextView tvResult;
    protected EditText etSerch;
    protected Button btnRequest;
    protected Button btnFind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMain = findViewById(R.id.tvMain);
        tvResult = findViewById(R.id.tvResult);
        etSerch = findViewById(R.id.etSerch);
        btnRequest = findViewById(R.id.btnRequest);
        btnFind = findViewById(R.id.btnFind);

    }

    public void onClickMain(View view) {
        i = new Intent(MainActivity.this, Activity2.class);
        i.putExtra("key_1", "Hi, write down a sentence with a few repeated words");
        i.putExtra("key_2", 100);
        i.putExtra("key_3", true);
        startActivityForResult(i, SENTENCE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {

            switch (requestCode) {
                case SENTENCE:
                    Log.d("myLog", "Result from Activity2: " + data.getStringExtra("sentence"));
                    mes = data.getStringExtra("sentence");
                    tvMain.setText("");
                    tvMain.setText(mes);
                    break;
                case SENTENCE_1:
//                    my code
                    break;

            }
        }
        btnRequest.setVisibility(View.INVISIBLE);
        btnFind.setVisibility(View.VISIBLE);
        tvResult.setVisibility(View.INVISIBLE);
        tvMain.setVisibility(View.VISIBLE);
        etSerch.setVisibility(View.VISIBLE);
        etSerch.setText("");

    }

    private String getWordCounter(String tData, String word) {
        String dataRet;
        int counter = 0;
        for (int i = 0; i < tData.length(); i++) {
            if (tData.substring(i).startsWith(word)) {
                counter++;
            }
        }
        dataRet = "The requested word - \"" + word + "\" occurs " + counter + " times in the text";

        return dataRet;
    }


    public void onCliclFind(View view) {
        tvResult.setText(getWordCounter(mes, etSerch.getText().toString()));
        etSerch.setVisibility(View.INVISIBLE);
        tvResult.setVisibility(View.VISIBLE);
        tvMain.setVisibility(View.VISIBLE);
        btnRequest.setVisibility(View.VISIBLE);
        btnFind.setVisibility(View.INVISIBLE);
    }
}