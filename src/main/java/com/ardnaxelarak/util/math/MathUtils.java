package com.ardnaxelarak.util.math;

import java.math.BigInteger;
import java.util.Collection;

public final class MathUtils {
  public static Congruence chineseRemainderTheorem(Collection<Congruence> equations) {
    for (Congruence c1 : equations) {
      for (Congruence c2 : equations) {
        if (c1 == c2) {
          continue;
        }

        if (!c1.getDivisor().gcd(c2.getDivisor()).equals(BigInteger.ONE)) {
          throw new IllegalArgumentException(
              "Divisors " + c1.getDivisor() + " and " + c2.getDivisor() + " are not coprime.");
        }
      }
    }

    Congruence collector = null;
    for (Congruence c : equations) {
      if (collector == null) {
        collector = c;
        continue;
      }

      EuclideanAlgorithmResult<BigInteger> bezout =
          getBezoutCoefficients(collector.getDivisor(), c.getDivisor());
      BigInteger divisorProduct = collector.getDivisor().multiply(c.getDivisor());
      collector =
          Congruence.create(
              divisorProduct,
              collector.getRemainder().multiply(c.getDivisor()).multiply(bezout.getSecondBezout())
                  .add(c.getRemainder().multiply(collector.getDivisor()).multiply(bezout.getFirstBezout()))
                  .mod(divisorProduct));
    }
    return collector;
  }

  public static EuclideanAlgorithmResult<BigInteger> getBezoutCoefficients(
      BigInteger first, BigInteger second) {
    if (first.equals(BigInteger.ZERO)) {
      return EuclideanAlgorithmResult.<BigInteger>builder()
          .setGcd(second)
          .setFirstInput(first)
          .setFirstBezout(BigInteger.ZERO)
          .setSecondInput(second)
          .setSecondBezout(second.equals(BigInteger.ZERO) ? BigInteger.ZERO : BigInteger.ONE)
          .build();
    } else if (second.equals(BigInteger.ZERO)) {
      return EuclideanAlgorithmResult.<BigInteger>builder()
          .setGcd(first)
          .setFirstInput(first)
          .setFirstBezout(BigInteger.ONE)
          .setSecondInput(second)
          .setSecondBezout(BigInteger.ZERO)
          .build();
    }


    BigInteger rLast;
    BigInteger sLast;
    BigInteger tLast;

    BigInteger rCurrent = first;
    BigInteger sCurrent = BigInteger.ONE;
    BigInteger tCurrent = BigInteger.ZERO;

    BigInteger rNext = second;
    BigInteger sNext = BigInteger.ZERO;
    BigInteger tNext = BigInteger.ONE;

    BigInteger quotient;

    while (!rNext.equals(BigInteger.ZERO)) {
      rLast = rCurrent;
      sLast = sCurrent;
      tLast = tCurrent;

      rCurrent = rNext;
      sCurrent = sNext;
      tCurrent = tNext;

      rNext = rLast.mod(rCurrent);
      quotient = rLast.divide(rCurrent);
      sNext = sLast.subtract(quotient.multiply(sCurrent));
      tNext = tLast.subtract(quotient.multiply(tCurrent));
    }

    return EuclideanAlgorithmResult.<BigInteger>builder()
        .setGcd(rCurrent)
        .setFirstInput(first)
        .setFirstBezout(sCurrent)
        .setSecondInput(second)
        .setSecondBezout(tCurrent)
        .build();
  }

  private MathUtils() {}
}
