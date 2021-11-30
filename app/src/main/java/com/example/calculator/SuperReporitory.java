package com.example.calculator;

import android.content.Context;

public class SuperReporitory {

    private static SuperReporitory INSTANCE;
    private Context context;

    private SuperReporitory(Context context) {
        this.context = context;
    }

    public static SuperReporitory getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SuperReporitory(context);
        }
        return INSTANCE;
    }

    public void doSomething() {

        String appName = context.getString(R.string.app_name);
    }
}

