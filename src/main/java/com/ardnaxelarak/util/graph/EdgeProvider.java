package com.ardnaxelarak.util.graph;

public interface EdgeProvider<T> {
  Iterable<Edge<T>> getEdges(T origin);
}
