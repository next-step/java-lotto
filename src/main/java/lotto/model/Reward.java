package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.enums.Grade;

public class Reward {

  private final long value;

  public Reward() {
    this(0L);
  }

  public Reward(Long value) {
    this.value = value;
  }

  public int result(Grade grade, List<Lotto> sellerLotto, Lotto winningLotto) {
    return winningLotto.coincideLotto(grade, sellerLotto);
  }

  public Reward winReward(Grade grade, int count) {
    return new Reward(this.value + grade.winningAmount(count));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reward that = (Reward) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
