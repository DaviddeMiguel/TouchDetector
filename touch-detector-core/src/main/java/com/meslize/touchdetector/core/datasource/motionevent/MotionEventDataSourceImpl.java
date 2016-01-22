package com.meslize.touchdetector.core.datasource.motionevent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.meslize.touchdetector.core.datasource.motionevent.entity.MotionEventEntity;
import com.meslize.touchdetector.core.reactive.Observable;

@SuppressLint("ViewConstructor") public class MotionEventDataSourceImpl extends FrameLayout
    implements MotionEventDataSource {

  private final Observable<MotionEventEntity> mObservable = new Observable<>();

  private MotionEventDataSourceImpl(Context context) {
    super(context);
  }

  public static MotionEventDataSourceImpl build(Activity activity) {
    MotionEventDataSourceImpl dataSource = new MotionEventDataSourceImpl(activity);
    dataSource.setLayoutParams(new ViewGroup.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
        FrameLayout.LayoutParams.MATCH_PARENT));

    return dataSource;
  }

  @Override public boolean dispatchTouchEvent(MotionEvent event) {
    super.dispatchTouchEvent(event);

    //TODO(david) The events should be filtered by type: click, scroll...
    mObservable.notifyOnNext(new MotionEventEntity(event));

    return true;
  }

  @Override protected void onDetachedFromWindow() {
    mObservable.notifyOnCompleted();
    super.onDetachedFromWindow();
  }

  @Override public void listen(View view) {
    addView(view);
  }

  @Override public void subscribe(Observable.Observer<MotionEventEntity> observer) {
    mObservable.subscribe(observer);
  }

  @Override public void unsubscribe(Observable.Observer<MotionEventEntity> observer) {
    mObservable.unSubscribe(observer);
  }
}
