package step2;

import java.util.Objects;

public class LottoFirstStat extends LottoStat {

  private int count;

  public LottoFirstStat() {
    this(0);
  }

  public LottoFirstStat(int count) {
    super("6개 일치", 2000000000);
    this.count = count;
  }

  @Override
  int getCount() {
    return count;
  }

  @Override
  void decide(int sameNumberCount) {
    if (sameNumberCount == 6) {
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
    LottoFirstStat that = (LottoFirstStat) o;
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
