package com.meslize.touchdetector.core.datasource.cache;

import com.google.gson.Gson;
import com.meslize.touchdetector.core.data.entity.TouchEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class CacheDataSourceImpl implements CacheDataSource {
  private static final CacheDataSourceImpl INSTANCE = new CacheDataSourceImpl();

  private HashMap<String, List<TouchEntity>> mMap;

  private CacheDataSourceImpl() {
  }

  public static CacheDataSource getInstance() {
    if (INSTANCE.mMap == null) {
      INSTANCE.mMap = new HashMap<>();
    }

    return INSTANCE;
  }

  @Override public void add(String key, TouchEntity item) {
    List<TouchEntity> items = mMap.get(key);
    if (items == null) {
      items = new ArrayList<>();
      mMap.put(key, items);
    }

    items.add(item);
  }

  @Override public void delete(String key) {
    mMap.remove(key);
  }

  @Override public void clear() {
    mMap.clear();
  }

  @Override public List<TouchEntity> getItems(String key) {
    return mMap.get(key) == null ? new ArrayList<TouchEntity>(0) : mMap.get(key);
  }

  @Override public String getItemsAsString(String key) {
    Gson gson = new Gson();
    return gson.toJson(getItems(key));
  }
}
