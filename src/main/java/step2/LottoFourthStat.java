package step2;

import java.util.Objects;

public class LottoFourthStat extends LottoStat {

  private int count;

  public LottoFourthStat() {
    this(0);
  }

  public LottoFourthStat(int count) {
    super("3개 일치", 5000);
    this.count = count;
  }

  @Override
  int getCount() {
    return count;
  }

  @Override
  void decide(int sameNumberCount) {
    if (sameNumberCount == 3) {
      count++;
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
    LottoFourthStat that = (LottoFourthStat) o;
    return count == that.count;
  }

  @Override
  public int hashCode() {
    return Objects.hash(count);
  }

  @Override
  public String toString() {
    return String.format("%s (%d원)- %d개", getMessage(), getAmount(), count);
  }
}
