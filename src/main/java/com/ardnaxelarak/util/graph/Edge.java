package com.ardnaxelarak.util.graph;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Edge<T> {
  public abstract T getValue();
  public abstract long getCost();

  public static <T> Edge<T> create(T value, long cost) {
    return new AutoValue_Edge(value, cost);
  }
}
