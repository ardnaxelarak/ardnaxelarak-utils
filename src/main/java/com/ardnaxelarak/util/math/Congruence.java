package com.ardnaxelarak.util.math;

import com.google.auto.value.AutoValue;
import java.math.BigInteger;

@AutoValue
public abstract class Congruence {
  public abstract BigInteger getDivisor();
  public abstract BigInteger getRemainder();

  public static Congruence create(BigInteger divisor, BigInteger remainder) {
    return new AutoValue_Congruence(divisor, remainder);
  }

  public static Congruence create(long divisor, long remainder) {
    return create(BigInteger.valueOf(divisor), BigInteger.valueOf(remainder));
  }
}
