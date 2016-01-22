package com.meslize.touchdetector.core.domain.model.mapper;

import com.meslize.touchdetector.core.datasource.motionevent.entity.MotionEventEntity;
import com.meslize.touchdetector.core.domain.model.TouchModel;

public class TouchModelMapper {
  public TouchModel map(MotionEventEntity data) {
    return new TouchModel(data.getTimeInMillis(), data.getX(), data.getY());
  }
}
