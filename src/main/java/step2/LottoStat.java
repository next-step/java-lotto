package step2;

import java.util.Objects;

public abstract class LottoStat {

  public enum Grade {
    First(6, 2000000000),
    Second(5, 1500000),
    Third(4, 50000),
    Fourth(3, 5000);

    private int sameCount;
    private int amount;

    Grade(int sameCount, int amount) {
      this.sameCount = sameCount;
      this.amount = amount;
    }

    public int getSameCount() {
      return sameCount;
    }

    public int getAmount() {
      return amount;
    }

    public boolean isWin(int sameCount) {
      return this.sameCount == sameCount;
    }

    @Override
    public String toString() {
      return String.format("%d개 일치 (%d원)", sameCount, amount);
    }
  }

  private final Grade grade;
  private int count;

  LottoStat(Grade grade, int count) {
    this.grade = grade;
    this.count = count;
  }

  public int total() {
    return grade.getAmount() * count;
  }

  public void decide(int sameNumberCount) {
    if (grade.isWin(sameNumberCount)) {
      count++;
    }
  }

  public int getCount() {
    return count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoStat lottoStat = (LottoStat) o;
    return count == lottoStat.count &&
        grade == lottoStat.grade;
  }

  @Override
  public int hashCode() {
    return Objects.hash(grade, count);
  }

  @Override
  public String toString() {
    return String.format("%s- %d개", grade, count);
  }

}
