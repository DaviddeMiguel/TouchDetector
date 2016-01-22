package com.meslize.touchdetector.core.datasource.motionevent;

import android.view.View;
import com.meslize.touchdetector.core.datasource.motionevent.entity.MotionEventEntity;
import com.meslize.touchdetector.core.reactive.Observable;

public interface MotionEventDataSource {
  void listen(View view);

  void subscribe(Observable.Observer<MotionEventEntity> observer);

  void unsubscribe(Observable.Observer<MotionEventEntity> observer);
}
