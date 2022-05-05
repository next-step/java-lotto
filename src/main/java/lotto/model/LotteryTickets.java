package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.exception.LottoSizeException;

public final class LotteryTickets {

  private final List<Lotto> value;

  public LotteryTickets(List<Lotto> value) {
    validate(value.size());
    this.value = value;
  }

  public List<Lotto> currentTickets() {
    return value;
  }

  private void validate(int size) {
    if (size < 0) {
      throw new LottoSizeException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LotteryTickets that = (LotteryTickets) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
