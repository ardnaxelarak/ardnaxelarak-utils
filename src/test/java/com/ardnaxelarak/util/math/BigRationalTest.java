package com.ardnaxelarak.util.math;

import static com.ardnaxelarak.util.math.BigRational.valueOf;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import org.junit.Test;

public class BigRationalTest {
  @Test
  public void testReduction() {
    assertThat(valueOf(28, 16)).isEqualTo(valueOf(7, 4));
    assertThat(valueOf(35, 20)).isEqualTo(valueOf(7, 4));
    assertThat(valueOf(0, 25)).isEqualTo(valueOf(0, 1));
    assertThat(valueOf(0, -25)).isEqualTo(valueOf(0, 1));
    assertThat(valueOf(1, -25)).isEqualTo(valueOf(-1, 25));
  }

  @Test
  public void testIntValue() {
    assertThat(valueOf(16, 8).intValue()).isEqualTo(2);
    assertThat(valueOf(16, -8).intValue()).isEqualTo(-2);
    assertThat(valueOf(0, 8).intValue()).isEqualTo(0);
    assertThat(valueOf(0, -8).intValue()).isEqualTo(0);
    assertThat(valueOf(7, 8).intValue()).isEqualTo(0);
    assertThat(valueOf(-7, 8).intValue()).isEqualTo(0);
    assertThat(valueOf(15, 8).intValue()).isEqualTo(1);
    assertThat(valueOf(-15, 8).intValue()).isEqualTo(-1);
    assertThat(valueOf(3, 0).intValue()).isEqualTo(Integer.MAX_VALUE);
    assertThat(valueOf(-3, 0).intValue()).isEqualTo(Integer.MIN_VALUE);
  }

  @Test
  public void testLongValue() {
    assertThat(valueOf(16, 8).longValue()).isEqualTo(2);
    assertThat(valueOf(16, -8).longValue()).isEqualTo(-2);
    assertThat(valueOf(0, 8).longValue()).isEqualTo(0);
    assertThat(valueOf(0, -8).longValue()).isEqualTo(0);
    assertThat(valueOf(7, 8).longValue()).isEqualTo(0);
    assertThat(valueOf(-7, 8).longValue()).isEqualTo(0);
    assertThat(valueOf(15, 8).longValue()).isEqualTo(1);
    assertThat(valueOf(-15, 8).longValue()).isEqualTo(-1);
    assertThat(valueOf(3, 0).longValue()).isEqualTo(Long.MAX_VALUE);
    assertThat(valueOf(-3, 0).longValue()).isEqualTo(Long.MIN_VALUE);
  }

  @Test
  public void testDoubleValue() {
    assertThat(valueOf(16, 8).doubleValue()).isEqualTo(2);
    assertThat(valueOf(16, -8).doubleValue()).isEqualTo(-2);
    assertThat(valueOf(0, 8).doubleValue()).isEqualTo(0);
    assertThat(valueOf(0, -8).doubleValue()).isEqualTo(0);
    assertThat(valueOf(7, 8).doubleValue()).isEqualTo(0.875);
    assertThat(valueOf(-7, 8).doubleValue()).isEqualTo(-0.875);
    assertThat(valueOf(15, 8).doubleValue()).isEqualTo(1.875);
    assertThat(valueOf(-15, 8).doubleValue()).isEqualTo(-1.875);
    assertThat(valueOf(7, 10).doubleValue()).isEqualTo(0.7);
    assertThat(valueOf(3, 0).doubleValue()).isEqualTo(Double.POSITIVE_INFINITY);
    assertThat(valueOf(-3, 0).doubleValue()).isEqualTo(Double.NEGATIVE_INFINITY);
    assertThat(valueOf(0, 0).doubleValue()).isEqualTo(Double.NaN);
  }

  @Test
  public void testFloatValue() {
    assertThat(valueOf(16, 8).floatValue()).isEqualTo(2f);
    assertThat(valueOf(16, -8).floatValue()).isEqualTo(-2f);
    assertThat(valueOf(0, 8).floatValue()).isEqualTo(0f);
    assertThat(valueOf(0, -8).floatValue()).isEqualTo(0f);
    assertThat(valueOf(7, 8).floatValue()).isEqualTo(0.875f);
    assertThat(valueOf(-7, 8).floatValue()).isEqualTo(-0.875f);
    assertThat(valueOf(15, 8).floatValue()).isEqualTo(1.875f);
    assertThat(valueOf(-15, 8).floatValue()).isEqualTo(-1.875f);
    assertThat(valueOf(7, 10).floatValue()).isEqualTo(0.7f);
    assertThat(valueOf(3, 0).floatValue()).isEqualTo(Float.POSITIVE_INFINITY);
    assertThat(valueOf(-3, 0).floatValue()).isEqualTo(Float.NEGATIVE_INFINITY);
    assertThat(valueOf(0, 0).floatValue()).isEqualTo(Float.NaN);
  }
}
