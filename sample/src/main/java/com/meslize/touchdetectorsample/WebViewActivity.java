package com.meslize.touchdetectorsample;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.meslize.touchdetector.core.TouchDetector;

public class WebViewActivity extends AppCompatActivity {

  private static final String QUMRAM_URL = "https://www.qumram.com/";

  @Bind(R.id.toolbar) Toolbar mtToolbar;
  @Bind(R.id.web_view) WebView mWebView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_web_view);
    ButterKnife.bind(this);
    TouchDetector.bind(this);

    configActionBar();

    mWebView.loadUrl(QUMRAM_URL);
  }

  private void configActionBar() {
    setSupportActionBar(mtToolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar == null) {
      return;
    }

    actionBar.setDisplayHomeAsUpEnabled(true);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.activity_web_view, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      // Respond to the action bar's Up/Home button
      case android.R.id.home:
        NavUtils.navigateUpFromSameTask(this);
        return true;
      case R.id.view:
        DisplayTouches.display(this);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
