package com.meslize.touchdetector.core.reactive;

import java.util.ArrayList;
import java.util.List;

public class Observable<U> {

  private List<Observer<U>> mObservers = new ArrayList<>();

  public void subscribe(Observer<U> observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }

    if (mObservers.contains(observer)) {
      return;
    }

    mObservers.add(observer);
  }

  public void unSubscribe(Observer<U> observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }

    mObservers.remove(observer);
  }

  public void notifyOnNext(U data) {
    for (Observer<U> observer : mObservers) {
      observer.onNext(data);
    }
  }

  public void notifyOnCompleted() {
    for (Observer<U> observer : mObservers) {
      observer.onCompleted();
    }
  }

  public interface Observer<U> {
    void onNext(U arg);

    void onCompleted();
  }
}
