package com.ardnaxelarak.util.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public final class Graphs {
  public static <T> long getDistance(EdgeProvider<T> edges, T start, T end) {
    Map<T, Long> visited = new HashMap<>();
    Map<T, Long> unvisited = new HashMap<>();
    unvisited.put(start, 0L);

    while (!unvisited.isEmpty()) {
      T cur =
          unvisited.entrySet().stream()
              .min(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();

      long baseDist = unvisited.get(cur);
      visited.put(cur, baseDist);
      unvisited.remove(cur);

      if (cur.equals(end)) {
        return baseDist;
      }

      Iterable<Edge<T>> curEdges = edges.getEdges(cur);
      for (Edge<T> edge : curEdges) {
        T newT = edge.getValue();

        if (visited.containsKey(newT)) {
          continue;
        }

        long dist = baseDist + edge.getCost();
        
        if (!unvisited.containsKey(newT) || unvisited.get(newT) > dist) {
          unvisited.put(newT, dist);
        }
      }
    }

    return Long.MAX_VALUE;
  }

  private Graphs() {}
}
