package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.enums.Grade;

public class Statistics {

  private final long reward;

  public Statistics() {
    this(0L);
  }

  public Statistics(Long reward) {
    this.reward = reward;
  }

  public int result(Grade grade, List<Product> sellerProduct, Product winningProduct) {
    return winningProduct.coincideLotto(grade, sellerProduct);
  }

  public Statistics winReward(Grade grade, int count) {
    return new Statistics(this.reward + grade.winningAmount(count));
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
    return Objects.equals(reward, that.reward);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reward);
  }

  @Override
  public String toString() {
    return String.valueOf(reward);
  }
}
