package com.meslize.touchdetectorsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.toolbar) Toolbar mtToolbar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    setSupportActionBar(mtToolbar);
  }

  @OnClick(R.id.native_screen) void onClickNativeScreen() {
    startActivity(new Intent(this, LoginActivity.class));
  }

  @OnClick(R.id.web_screen) void onClickWebScreen() {
    startActivity(new Intent(this, WebViewActivity.class));
  }
}
