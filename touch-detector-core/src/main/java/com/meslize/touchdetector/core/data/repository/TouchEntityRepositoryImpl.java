package com.meslize.touchdetector.core.data.repository;

import com.meslize.touchdetector.core.data.entity.TouchEntity;
import com.meslize.touchdetector.core.data.entity.mapper.TouchEntityMapper;
import com.meslize.touchdetector.core.datasource.cache.CacheDataSource;
import com.meslize.touchdetector.core.domain.model.TouchModel;

public class TouchEntityRepositoryImpl implements TouchEntityRepository {

  private final CacheDataSource mCacheDataSource;
  private final TouchEntityMapper mTouchEntityMapper;

  public TouchEntityRepositoryImpl(CacheDataSource cacheDataSource,
      TouchEntityMapper touchEntityMapper) {
    this.mCacheDataSource = cacheDataSource;
    this.mTouchEntityMapper = touchEntityMapper;
  }

  @Override public void add(String key, TouchModel touch) {
    TouchEntity entity = mTouchEntityMapper.map(touch);
    mCacheDataSource.add(key, entity);
  }

  @Override public void delete(String key) {
    mCacheDataSource.delete(key);
  }
}
