package lotto.domain.result;

import java.util.Objects;

public class ProfitRate {

  private final float value;

  public ProfitRate(float value) {
    this.value = value;
  }

  public ProfitRate(int winningPrize, int purchasePrize) {
    this(calculateProfitRate(winningPrize, purchasePrize));
  }

  private static float calculateProfitRate(int winningPrize, int purchasePrize) {
    if (purchasePrize <= 0) {
      throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다");
    }
    if (winningPrize < 0) {
      throw new IllegalArgumentException("당첨 금액은 0 이상이어야 합니다");
    }
    return (float) winningPrize / purchasePrize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfitRate that = (ProfitRate) o;
    return Float.compare(that.value, value) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "총 수익률은 " + value + "입니다.(기준이 1이기 때문에 결과적으로 " + Explanation.getMessage(value)
        + "라는 의미임)";
  }

  enum Explanation {
    PROFIT("이익"), LOSS("손해");
    private String message;

    Explanation(String message) {
      this.message = message;
    }

    static String getMessage(float value) {
      if (value >= 1) {
        return PROFIT.message;
      }
      return LOSS.message;
    }
  }

}