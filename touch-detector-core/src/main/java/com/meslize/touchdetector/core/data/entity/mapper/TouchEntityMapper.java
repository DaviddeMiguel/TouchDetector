package com.meslize.touchdetector.core.data.entity.mapper;

import com.meslize.touchdetector.core.data.entity.TouchEntity;
import com.meslize.touchdetector.core.domain.model.TouchModel;

public class TouchEntityMapper {
  public TouchEntity map(TouchModel data) {
    return new TouchEntity.Builder().withTimeInMillis(data.getTimeInMillis())
        .withX(data.getX())
        .withY(data.getY())
        .withType(data.getType())
        .build();
  }
}
