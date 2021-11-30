package com.example.calculator.theme;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.calculator.R;

public enum Theme {
    ONE(R.style.Theme_Calculator, R.string.theme_one, "One"),
    TWO(R.style.Theme_Calculator_Second, R.string.theme_two, "Two"),
    THREE(R.style.Theme_Calculator_Third, R.string.theme_three, "Three"),
    FOUR(R.style.Theme_Calculator_Fourth, R.string.theme_four, "Four");

    public String getKey() {
        return key;
    }



    private String key;

    @StyleRes
    private final int theme;
    @StringRes
    private final int name;

    Theme(int theme, int name, String key) {
        this.theme = theme;
        this.name = name;
        this.key = key;
    }

    public int getTheme() {
        return theme;
    }

    public int getName() {
        return name;
    }
}
