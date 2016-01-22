package com.meslize.touchdetectorsample;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import com.meslize.touchdetector.core.datasource.cache.CacheDataSourceImpl;

public class DisplayTouches {
  private DisplayTouches() {
  }

  public static void display(Activity activity) {
    //TODO(david) Only for demo: this should not be accessible from the sdk
    String json = CacheDataSourceImpl.getInstance().getItemsAsString(activity.getClass().getName());

    // 1. Instantiate an AlertDialog.Builder with its constructor
    AlertDialog.Builder builder = new AlertDialog.Builder(activity);

    // 2. Chain together various setter methods to set the dialog characteristics
    builder.setMessage(json);

    // 3. Get the AlertDialog from create()
    AlertDialog dialog = builder.create();
    dialog.show();
  }
}
