package com.meslize.touchdetector.core.domain.model;

public class TouchModel {

  private long timeInMillis;
  private float x;
  private float y;
  private String type;

  public TouchModel(Builder builder) {
    this.timeInMillis = builder.timeInMillis;
    this.x = builder.x;
    this.y = builder.y;
    this.type = builder.type;
  }

  public long getTimeInMillis() {
    return timeInMillis;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public String getType() {
    return type;
  }

  public static final class Builder {
    private long timeInMillis;
    private float x;
    private float y;
    private String type;

    public Builder() {
    }

    public Builder withTimeInMillis(long val) {
      timeInMillis = val;
      return this;
    }

    public Builder withX(float val) {
      x = val;
      return this;
    }

    public Builder withY(float val) {
      y = val;
      return this;
    }

    public Builder withType(String val) {
      type = val;
      return this;
    }

    public TouchModel build() {
      return new TouchModel(this);
    }
  }
}
