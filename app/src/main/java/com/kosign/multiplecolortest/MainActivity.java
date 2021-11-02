package com.kosign.multiplecolortest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    public static final String MY_APP_SHARE_PRE = "app_share_pre";
    public static final String APP_THEME = "app_theme";

    private CardView cardYellow, cardBlue, cardPink;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(MY_APP_SHARE_PRE, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        cardYellow = findViewById(R.id.card_yellow);
        cardYellow.setOnClickListener(this);

        cardBlue = findViewById(R.id.card_blue);
        cardBlue.setOnClickListener(this);

        cardPink = findViewById(R.id.card_pink);
        cardPink.setOnClickListener(this);
    }

    public void recreateSmoothly() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_yellow:
                editor.putString(APP_THEME, "yellow");
                editor.apply();
                recreateSmoothly();
                break;
            case R.id.card_blue:
                editor.putString(APP_THEME, "blue");
                editor.apply();
                recreateSmoothly();
                break;
            case R.id.card_pink:
                editor.putString(APP_THEME, "pink");
                editor.apply();
                recreateSmoothly();
                break;
        }
    }
}