package com.ardnaxelarak.util.math;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import com.google.auto.value.AutoValue;
import java.math.BigInteger;

@AutoValue
public abstract class BigRational extends Number {
  public static final BigRational POSITIVE_INFINITY = BigRational.valueOf(1, 0);
  public static final BigRational NEGATIVE_INFINITY = BigRational.valueOf(-1, 0);
  public static final BigRational NaN = BigRational.valueOf(0, 0);

  public abstract BigInteger getNumerator();
  public abstract BigInteger getDenominator();

  private static BigRational valueOfReduced(BigInteger numerator, BigInteger denominator) {
    return new AutoValue_BigRational(numerator, denominator);
  }

  public static BigRational valueOf(BigInteger numerator, BigInteger denominator) {
    if (denominator.equals(ZERO)) {
      return valueOfReduced(BigInteger.valueOf(numerator.signum()), denominator);
    }

    if (denominator.signum() == -1) {
      numerator = numerator.negate();
      denominator = denominator.negate();
    }

    BigInteger gcd = numerator.gcd(denominator);
    if (gcd.equals(ONE)) {
      return valueOfReduced(numerator, denominator);
    } else {
      return valueOfReduced(numerator.divide(gcd), denominator.divide(gcd));
    }
  }

  public static BigRational valueOf(long numerator, long denominator) {
    return valueOf(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
  }

  @Override
  public int intValue() {
    if (getDenominator().equals(ZERO)) {
      switch (getNumerator().signum()) {
        case 1:
          return Integer.MAX_VALUE;
        case -1:
          return Integer.MIN_VALUE;
        case 0:
        default:
          throw new ArithmeticException("Undefined value");
      }
    }
    return getNumerator().divide(getDenominator()).intValue();
  }

  @Override
  public long longValue() {
    if (getDenominator().equals(ZERO)) {
      switch (getNumerator().signum()) {
        case 1:
          return Long.MAX_VALUE;
        case -1:
          return Long.MIN_VALUE;
        case 0:
        default:
          throw new ArithmeticException("Undefined value");
      }
    }
    return getNumerator().divide(getDenominator()).longValue();
  }

  @Override
  public double doubleValue() {
    if (getDenominator().equals(ZERO)) {
      switch (getNumerator().signum()) {
        case 1:
          return Double.POSITIVE_INFINITY;
        case -1:
          return Double.NEGATIVE_INFINITY;
        case 0:
        default:
          return Double.NaN;
      }
    }
    return getNumerator().doubleValue() / getDenominator().doubleValue();
  }

  @Override
  public float floatValue() {
    if (getDenominator().equals(ZERO)) {
      switch (getNumerator().signum()) {
        case 1:
          return Float.POSITIVE_INFINITY;
        case -1:
          return Float.NEGATIVE_INFINITY;
        case 0:
        default:
          return Float.NaN;
      }
    }
    return getNumerator().floatValue() / getDenominator().floatValue();
  }
}
