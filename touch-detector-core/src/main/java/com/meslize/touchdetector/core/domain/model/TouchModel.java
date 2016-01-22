package com.meslize.touchdetector.core.domain.model;

public class TouchModel {
  private final long mTimeInMillis;
  private final float mX;
  private final float mY;

  public TouchModel(long mTimeInMillis, float mX, float mY) {
    this.mTimeInMillis = mTimeInMillis;
    this.mX = mX;
    this.mY = mY;
  }

  public long getTimeInMillis() {
    return mTimeInMillis;
  }

  public float getX() {
    return mX;
  }

  public float getY() {
    return mY;
  }
}
