package lotto.domain;

import java.util.Objects;

public class Rate {

  private final double rate;

  public static Rate of(double rate) {
    return new Rate(rate);
  }

  private Rate(double rate) {
    this.rate = rate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rate rate1 = (Rate) o;
    return Double.compare(rate1.rate, rate) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rate);
  }

  @Override
  public String toString() {
    return String.valueOf(rate);
  }

  public double getRate() {
    return rate;
  }
}
