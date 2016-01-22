package com.meslize.touchdetector.core.datasource.cache;

import com.meslize.touchdetector.core.data.entity.TouchEntity;
import java.util.List;

public interface CacheDataSource {
  void add(String key, TouchEntity item);

  void delete(String key);

  List<TouchEntity> getItems(String key);

  String getItemsAsString(String key);

  void clear();
}
