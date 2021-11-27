package lotto.domain.entity;

public class YieldRate {

  private static final String INVALID_YIELD_RATE_MESSAGE = "비율이 0보다 작습니다.";

  private static final int ONE = 1;

  private final double rate;

  public YieldRate(double rate) {
    if (rate < 0) {
      throw new IllegalArgumentException(INVALID_YIELD_RATE_MESSAGE);
    }
    this.rate = rate;
  }

  public double getRate() {
    return rate;
  }

  public boolean isYieldRateLessThanOne() {
    return rate < ONE;
  }
}
