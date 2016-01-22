package com.meslize.touchdetector.core.datasource.motionevent.entity;

import android.view.MotionEvent;
import java.util.Calendar;

public class MotionEventEntity {

  public static final String TYPE_DOWN = "DOWN";
  public static final String TYPE_MOVE = "MOVE";
  public static final String TYPE_UP = "UP";
  public static final String TYPE_UNKNOWN = "UNKNOWN";

  private final long timeInMillis;
  private final MotionEvent motionEvent;

  public MotionEventEntity(MotionEvent motionEvent) {
    this.timeInMillis = Calendar.getInstance().getTimeInMillis();
    this.motionEvent = motionEvent;
  }

  public long getTimeInMillis() {
    return timeInMillis;
  }

  public float getX() {
    return motionEvent.getX();
  }

  public float getY() {
    return motionEvent.getY();
  }

  public String getType() {
    switch (motionEvent.getAction()) {
      case MotionEvent.ACTION_DOWN:
        return TYPE_DOWN;
      case MotionEvent.ACTION_MOVE:
        return TYPE_MOVE;
      case MotionEvent.ACTION_UP:
        return TYPE_UP;
      default:
        return TYPE_UNKNOWN;
    }
  }
}
