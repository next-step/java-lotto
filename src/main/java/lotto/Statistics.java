package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public final class Statistics {

  private final int expectCount;

  public Statistics(int expectCount) {
    this.expectCount = expectCount;
  }

  public int coincideLotto(List<Product> allProducts, List<Integer> winNumbers) {
    int result = 0;
    for (Product product : allProducts) {
      result += LottoConfirm.increaseProductNumber(expectCount,  product, winNumbers);
    }
    return result;
  }

  public int winningAmount(int cost, int count) {
    return cost * count;
  }

  public double yield(int winningAmount, int haveMoney) {
    return Math.floor((double) winningAmount / haveMoney * 100) / 100.0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statistics that = (Statistics) o;
    return expectCount == that.expectCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(expectCount);
  }
}
