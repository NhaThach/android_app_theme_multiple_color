package com.kosign.multiplecolortest;

import static com.kosign.multiplecolortest.MainActivity.APP_THEME;
import static com.kosign.multiplecolortest.MainActivity.MY_APP_SHARE_PRE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences(MY_APP_SHARE_PRE, MODE_PRIVATE);
        String appTheme = sharedPreferences.getString(APP_THEME, ThemeComponents.YELLOW);

        if (appTheme.equals("yellow")) {
            setTheme(R.style.Theme_Yellow);
        }
        else if (appTheme.equals("blue")) {
            setTheme(R.style.Theme_Blue);
        }
        else {
            setTheme(R.style.Theme_Pink);
        }

        super.onCreate(savedInstanceState);
    }
}