package step2;

import java.util.Objects;

public class LottoThirdStat extends LottoStat {

  private int count;

  public LottoThirdStat() {
    this(0);
  }

  public LottoThirdStat(int count) {
    super(Grade.Third);
    this.count = count;
  }

  @Override
  int getCount() {
    return count;
  }

  @Override
  void decide(int sameNumberCount) {
    if (sameNumberCount == grade.getSameCount()) {
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
    LottoThirdStat that = (LottoThirdStat) o;
    return count == that.count;
  }

  @Override
  public int hashCode() {
    return Objects.hash(count);
  }

  @Override
  public String toString() {
    return String.format("%s- %d개", grade, count);
  }
}
