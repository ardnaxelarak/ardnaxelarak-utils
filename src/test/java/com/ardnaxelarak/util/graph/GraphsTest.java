package com.ardnaxelarak.util.graph;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

public class GraphsTest {
  @Test
  public void testGetDistance() {
    Table<String, String, Long> map = HashBasedTable.create();
    map.put("A", "B", 3L);
    map.put("B", "A", 3L);
    map.put("B", "C", 5L);
    map.put("C", "B", 5L);
    map.put("B", "D", 7L);
    map.put("D", "B", 7L);
    map.put("D", "F", 9L);
    map.put("F", "D", 9L);
    map.put("C", "E", 6L);
    map.put("E", "C", 6L);
    map.put("E", "F", 4L);
    map.put("F", "E", 4L);

    EdgeProvider<String> edges = EdgeProviders.fromTable(map);

    assertThat(Graphs.getDistance(edges, "A", "B")).isEqualTo(3);
    assertThat(Graphs.getDistance(edges, "A", "C")).isEqualTo(8);
    assertThat(Graphs.getDistance(edges, "A", "D")).isEqualTo(10);
    assertThat(Graphs.getDistance(edges, "A", "E")).isEqualTo(14);
    assertThat(Graphs.getDistance(edges, "A", "F")).isEqualTo(18);
    assertThat(Graphs.getDistance(edges, "B", "A")).isEqualTo(3);
    assertThat(Graphs.getDistance(edges, "B", "C")).isEqualTo(5);
    assertThat(Graphs.getDistance(edges, "B", "D")).isEqualTo(7);
    assertThat(Graphs.getDistance(edges, "B", "E")).isEqualTo(11);
    assertThat(Graphs.getDistance(edges, "B", "F")).isEqualTo(15);
    assertThat(Graphs.getDistance(edges, "C", "A")).isEqualTo(8);
    assertThat(Graphs.getDistance(edges, "C", "B")).isEqualTo(5);
    assertThat(Graphs.getDistance(edges, "C", "D")).isEqualTo(12);
    assertThat(Graphs.getDistance(edges, "C", "E")).isEqualTo(6);
    assertThat(Graphs.getDistance(edges, "C", "F")).isEqualTo(10);
    assertThat(Graphs.getDistance(edges, "D", "A")).isEqualTo(10);
    assertThat(Graphs.getDistance(edges, "D", "B")).isEqualTo(7);
    assertThat(Graphs.getDistance(edges, "D", "C")).isEqualTo(12);
    assertThat(Graphs.getDistance(edges, "D", "E")).isEqualTo(13);
    assertThat(Graphs.getDistance(edges, "D", "F")).isEqualTo(9);
    assertThat(Graphs.getDistance(edges, "E", "A")).isEqualTo(14);
    assertThat(Graphs.getDistance(edges, "E", "B")).isEqualTo(11);
    assertThat(Graphs.getDistance(edges, "E", "C")).isEqualTo(6);
    assertThat(Graphs.getDistance(edges, "E", "D")).isEqualTo(13);
    assertThat(Graphs.getDistance(edges, "E", "F")).isEqualTo(4);
    assertThat(Graphs.getDistance(edges, "F", "A")).isEqualTo(18);
    assertThat(Graphs.getDistance(edges, "F", "B")).isEqualTo(15);
    assertThat(Graphs.getDistance(edges, "F", "C")).isEqualTo(10);
    assertThat(Graphs.getDistance(edges, "F", "D")).isEqualTo(9);
    assertThat(Graphs.getDistance(edges, "F", "E")).isEqualTo(4);
  }
}
