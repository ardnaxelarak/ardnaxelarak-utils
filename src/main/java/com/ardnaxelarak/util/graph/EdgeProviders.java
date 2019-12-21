package com.ardnaxelarak.util.graph;

import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Table;
import java.util.Set;

public final class EdgeProviders {
  public static <T> MultimapEdgeProvider<T> fromTable(Table<T, T, Long> table) {
    ImmutableSetMultimap.Builder<T, Edge<T>> builder = ImmutableSetMultimap.builder();
    Set<Table.Cell<T, T, Long>> cells = table.cellSet();
    for (Table.Cell<T, T, Long> cell : cells) {
      builder.put(cell.getRowKey(), Edge.create(cell.getColumnKey(), cell.getValue()));
    }
    return new MultimapEdgeProvider<>(builder.build());
  }

  public static <T> MultimapEdgeProvider<T> fromBidirectionalTable(Table<T, T, Long> table) {
    ImmutableSetMultimap.Builder<T, Edge<T>> builder = ImmutableSetMultimap.builder();
    Set<Table.Cell<T, T, Long>> cells = table.cellSet();
    for (Table.Cell<T, T, Long> cell : cells) {
      builder.put(cell.getRowKey(), Edge.create(cell.getColumnKey(), cell.getValue()));
      builder.put(cell.getColumnKey(), Edge.create(cell.getRowKey(), cell.getValue()));
    }
    return new MultimapEdgeProvider<>(builder.build());
  }

  private EdgeProviders() {}
}

