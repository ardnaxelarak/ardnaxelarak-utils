package com.ardnaxelarak.util.graph;

import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Multimap;

public class MultimapEdgeProvider<T> implements EdgeProvider<T> {
  private ImmutableSetMultimap<T, Edge<T>> edges;

  public MultimapEdgeProvider(Multimap<T, Edge<T>> edges) {
    this.edges = ImmutableSetMultimap.copyOf(edges);
  }

  public Iterable<Edge<T>> getEdges(T origin) {
    return edges.get(origin);
  }
}

