package com.ardnaxelarak.util.math;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EuclideanAlgorithmResult<T extends Number> {
  public abstract T getGcd();
  public abstract T getFirstInput();
  public abstract T getFirstBezout();
  public abstract T getSecondInput();
  public abstract T getSecondBezout();

  public static <T extends Number> Builder<T> builder() {
    return new AutoValue_EuclideanAlgorithmResult.Builder<T>();
  }

  @AutoValue.Builder
  public abstract static class Builder<T extends Number> {
    public abstract Builder<T> setGcd(T value);
    public abstract Builder<T> setFirstInput(T value);
    public abstract Builder<T> setFirstBezout(T value);
    public abstract Builder<T> setSecondInput(T value);
    public abstract Builder<T> setSecondBezout(T value);

    public abstract EuclideanAlgorithmResult<T> build();
  }
}
