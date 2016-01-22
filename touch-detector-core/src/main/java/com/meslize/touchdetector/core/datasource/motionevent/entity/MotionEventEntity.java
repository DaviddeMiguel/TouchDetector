package com.meslize.touchdetector.core.datasource.motionevent.entity;

import android.view.MotionEvent;
import java.util.Calendar;

public class MotionEventEntity {
  private final long mTimeInMillis;
  private final MotionEvent mMotionEvent;

  public MotionEventEntity(MotionEvent motionEvent) {
    this.mTimeInMillis = Calendar.getInstance().getTimeInMillis();
    this.mMotionEvent = motionEvent;
  }

  public long getTimeInMillis() {
    return mTimeInMillis;
  }

  public float getX() {
    return mMotionEvent.getX();
  }

  public float getY() {
    return mMotionEvent.getY();
  }
}
