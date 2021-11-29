package com.example.calculator.theme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.Constants;
import com.example.calculator.R;

public class CalculatorThemeActivity extends AppCompatActivity implements Constants {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_theme);
        LinearLayout themeContainer = findViewById(R.id.themes);
        for (Theme theme : Theme.values()) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_theme, themeContainer, false);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CalculatorThemeActivity.this, theme.getName(), Toast.LENGTH_SHORT).show();
                }
            });
            TextView themeItemTitle = view.findViewById(R.id.them_item);
            themeItemTitle.setText(theme.getName());

            themeContainer.addView(view);
        }

    }
}