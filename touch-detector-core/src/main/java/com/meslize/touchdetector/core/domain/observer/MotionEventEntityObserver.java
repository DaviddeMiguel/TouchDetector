package com.meslize.touchdetector.core.domain.observer;

import com.meslize.touchdetector.core.data.repository.TouchEntityRepository;
import com.meslize.touchdetector.core.datasource.motionevent.entity.MotionEventEntity;
import com.meslize.touchdetector.core.domain.model.mapper.TouchModelMapper;
import com.meslize.touchdetector.core.reactive.Observable;

public class MotionEventEntityObserver implements Observable.Observer<MotionEventEntity> {

  private final String mScreen;
  private final TouchEntityRepository mTouchEntityRepository;
  private final TouchModelMapper mTouchModelMapper;

  public MotionEventEntityObserver(String screen, TouchEntityRepository mTouchEntityRepository,
      TouchModelMapper touchModelMapper) {
    this.mScreen = screen;
    this.mTouchEntityRepository = mTouchEntityRepository;
    mTouchModelMapper = touchModelMapper;
  }

  @Override public void onNext(MotionEventEntity entity) {
    mTouchEntityRepository.add(mScreen, mTouchModelMapper.map(entity));
  }

  @Override public void onCompleted() {
    //TODO(david) Sync the events instead of clean the cache for this screen
    mTouchEntityRepository.delete(mScreen);
  }
}
