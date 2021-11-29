package com.example.calculator.theme;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.calculator.R;

public enum Theme {
    ONE(R.style.Theme_Calculator, R.string.theme_one),
    TWO(R.style.Theme_Calculator_Second, R.string.theme_two),
    THREE(R.style.Theme_Calculator_Third, R.string.theme_three),
    FOUR(R.style.Theme_Calculator_Fourth, R.string.theme_four);


    @StyleRes
    private final int theme;
    @StringRes
    private final int name;

    Theme(int theme, int name) {
        this.theme = theme;
        this.name = name;
    }

    public int getTheme() {
        return theme;
    }

    public int getName() {
        return name;
    }
}
