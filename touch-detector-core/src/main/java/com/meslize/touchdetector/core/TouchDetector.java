package com.meslize.touchdetector.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.meslize.touchdetector.core.data.entity.mapper.TouchEntityMapper;
import com.meslize.touchdetector.core.data.repository.TouchEntityRepository;
import com.meslize.touchdetector.core.data.repository.TouchEntityRepositoryImpl;
import com.meslize.touchdetector.core.datasource.cache.CacheDataSource;
import com.meslize.touchdetector.core.datasource.cache.CacheDataSourceImpl;
import com.meslize.touchdetector.core.datasource.motionevent.MotionEventDataSource;
import com.meslize.touchdetector.core.datasource.motionevent.MotionEventDataSourceImpl;
import com.meslize.touchdetector.core.domain.model.mapper.TouchModelMapper;
import com.meslize.touchdetector.core.domain.observer.MotionEventEntityObserver;

public class TouchDetector {
  public static void bind(Activity activity) {
    final ViewGroup content = (ViewGroup) activity.findViewById(android.R.id.content);
    final ViewGroup parent = (ViewGroup) content.getParent();
    parent.removeView(content);

    CacheDataSource cacheDataSource = CacheDataSourceImpl.getInstance();
    TouchEntityMapper touchEntityMapper = new TouchEntityMapper();

    String screen = activity.getClass().getName();
    TouchEntityRepository touchEntityRepository =
        new TouchEntityRepositoryImpl(cacheDataSource, touchEntityMapper);
    TouchModelMapper touchModelMapper = new TouchModelMapper();

    MotionEventEntityObserver motionEventEntityObserver =
        new MotionEventEntityObserver(screen, touchEntityRepository, touchModelMapper);

    MotionEventDataSource motionEventDataSource = MotionEventDataSourceImpl.build(activity);
    motionEventDataSource.subscribe(motionEventEntityObserver);

    motionEventDataSource.listen(content);
    parent.addView((View) motionEventDataSource);
  }
}
