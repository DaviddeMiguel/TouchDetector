package com.meslize.touchdetector.core.data.entity;

public class TouchEntity {

  public final long time;
  public final float x;
  public final float y;

  public TouchEntity(long time, float x, float y) {
    this.time = time;
    this.x = x;
    this.y = y;
  }
}
