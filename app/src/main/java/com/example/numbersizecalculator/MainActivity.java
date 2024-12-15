package com.example.numbersizecalculator;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.numbersizecalculator.watcher.NumberWatcher;

public class MainActivity extends AppCompatActivity {
    private EditText numberInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.InputNumber);
        numberInput.addTextChangedListener(new NumberWatcher(
                findViewById(R.id.BitSizeOut),
                findViewById(R.id.ByteSizeOut),
                findViewById(R.id.TypeOut)
        ));
    }
}
