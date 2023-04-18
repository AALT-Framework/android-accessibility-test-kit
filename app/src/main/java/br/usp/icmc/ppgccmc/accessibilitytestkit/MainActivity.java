package br.usp.icmc.ppgccmc.accessibilitytestkit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textLabel;
    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLabel = findViewById(R.id.text_label);
        btnTest = findViewById(R.id.btn_test);
    }
}