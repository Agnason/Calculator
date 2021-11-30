package com.example.calculator.theme;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.Constants;
import com.example.calculator.R;

public class CalculatorThemeActivity extends AppCompatActivity implements Constants {

    public static final String EXTRA_THEME = "EXTRA_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_theme);

        Intent launchIntent = getIntent();

        if (launchIntent.hasExtra(EXTRA_THEME)) {

        }
        Theme selectedTheme = (Theme) launchIntent.getSerializableExtra(EXTRA_THEME);

        LinearLayout themeContainer = findViewById(R.id.themes);
        for (Theme theme : Theme.values()) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_theme, themeContainer, false);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CalculatorThemeActivity.this, theme.getName(), Toast.LENGTH_SHORT).show();

                    Intent data = new Intent();
                    data.putExtra(EXTRA_THEME, theme);
                    setResult(Activity.RESULT_OK, data);
                    finish();
                }
            });
            TextView themeItemTitle = view.findViewById(R.id.theme_item);
            themeItemTitle.setText(theme.getName());

            ImageView check = view.findViewById(R.id.check);
            if (theme.equals(selectedTheme)) {
                check.setVisibility(View.VISIBLE);
            } else {
                check.setVisibility(View.GONE);
            }
            themeContainer.addView(view);
        }
findViewById(R.id.open_browser).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri yandexUri = Uri.parse("https://ya.ru");
        Intent intent = new Intent(Intent.ACTION_VIEW, yandexUri);
       startActivity(Intent.createChooser(intent,""));

    }
});
    }
}