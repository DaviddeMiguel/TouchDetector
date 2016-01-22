package com.meslize.touchdetector.core.data.repository;

import com.meslize.touchdetector.core.domain.model.TouchModel;

public interface TouchEntityRepository {
  void add(String key, TouchModel touch);

  void delete(String key);
}
