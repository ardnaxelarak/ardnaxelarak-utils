package com.ardnaxelarak.util.math;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import org.junit.Test;

public class MathUtilsTest {
  @Test
  public void testGetBezout_BigInteger() {
    assertThat(MathUtils.getBezoutCoefficients(BigInteger.valueOf(14), BigInteger.valueOf(12)))
        .isEqualTo(
            EuclideanAlgorithmResult.<BigInteger>builder()
                .setGcd(BigInteger.valueOf(2))
                .setFirstInput(BigInteger.valueOf(14))
                .setFirstBezout(BigInteger.valueOf(1))
                .setSecondInput(BigInteger.valueOf(12))
                .setSecondBezout(BigInteger.valueOf(-1))
                .build());
    assertThat(MathUtils.getBezoutCoefficients(BigInteger.valueOf(12), BigInteger.valueOf(14)))
        .isEqualTo(
            EuclideanAlgorithmResult.<BigInteger>builder()
                .setGcd(BigInteger.valueOf(2))
                .setFirstInput(BigInteger.valueOf(12))
                .setFirstBezout(BigInteger.valueOf(-1))
                .setSecondInput(BigInteger.valueOf(14))
                .setSecondBezout(BigInteger.valueOf(1))
                .build());
    assertThat(MathUtils.getBezoutCoefficients(BigInteger.valueOf(21), BigInteger.valueOf(35)))
        .isEqualTo(
            EuclideanAlgorithmResult.<BigInteger>builder()
                .setGcd(BigInteger.valueOf(7))
                .setFirstInput(BigInteger.valueOf(21))
                .setFirstBezout(BigInteger.valueOf(2))
                .setSecondInput(BigInteger.valueOf(35))
                .setSecondBezout(BigInteger.valueOf(-1))
                .build());
    assertThat(MathUtils.getBezoutCoefficients(BigInteger.ZERO, BigInteger.valueOf(27)))
        .isEqualTo(
            EuclideanAlgorithmResult.<BigInteger>builder()
                .setGcd(BigInteger.valueOf(27))
                .setFirstInput(BigInteger.ZERO)
                .setFirstBezout(BigInteger.ZERO)
                .setSecondInput(BigInteger.valueOf(27))
                .setSecondBezout(BigInteger.ONE)
                .build());
    assertThat(MathUtils.getBezoutCoefficients(BigInteger.valueOf(27), BigInteger.ZERO))
        .isEqualTo(
            EuclideanAlgorithmResult.<BigInteger>builder()
                .setGcd(BigInteger.valueOf(27))
                .setFirstInput(BigInteger.valueOf(27))
                .setFirstBezout(BigInteger.ONE)
                .setSecondInput(BigInteger.ZERO)
                .setSecondBezout(BigInteger.ZERO)
                .build());
    assertThat(MathUtils.getBezoutCoefficients(BigInteger.ZERO, BigInteger.ZERO))
        .isEqualTo(
            EuclideanAlgorithmResult.<BigInteger>builder()
                .setGcd(BigInteger.ZERO)
                .setFirstInput(BigInteger.ZERO)
                .setFirstBezout(BigInteger.ZERO)
                .setSecondInput(BigInteger.ZERO)
                .setSecondBezout(BigInteger.ZERO)
                .build());
  }

  @Test
  public void testChineseRemainderTheorem() {
    assertThat(
            MathUtils.chineseRemainderTheorem(
                ImmutableList.of(
                    Congruence.create(3, 2),
                    Congruence.create(5, 3),
                    Congruence.create(7, 2))))
        .isEqualTo(Congruence.create(105, 23));
  }
}

