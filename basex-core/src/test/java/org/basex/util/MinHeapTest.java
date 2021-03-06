package org.basex.util;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

/**
 * Tests for the {@link MinHeap} implementation.
 *
 * @author BaseX Team 2005-14, BSD License
 * @author Leo Woerteler
 */
public final class MinHeapTest {
  /** Checks if the heap can be used for sorting. */
  @Test
  public void heapSort() {
    final MinHeap<Integer, Integer> heap = new MinHeap<>(2, null);
    final Integer[] vals = new Integer[1000];
    for(int i = 0; i < vals.length; i++) vals[i] = i;
    Collections.shuffle(Arrays.asList(vals));

    for(final int i : vals) {
      heap.insert(i, i);
      heap.verify();
    }

    int i = 0;
    while(!heap.isEmpty()) {
      assertEquals(Integer.valueOf(i++), heap.removeMin());
      heap.verify();
    }
    assertEquals(1000, i);
  }

  /** Checks if the heap can be used for sorting a pre-sorted sequence. */
  @Test
  public void heapPreSort() {
    final MinHeap<Integer, Integer> heap = new MinHeap<>(2, null);
    for(int i = 0; i < 1000; i++) {
      heap.insert(i, i);
      heap.verify();
    }

    int i = 0;
    while(!heap.isEmpty()) {
      assertEquals(i++, heap.removeMin().intValue());
      heap.verify();
    }
    assertEquals(1000, i);
  }
}
