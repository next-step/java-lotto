package step2;

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

    @Override
    public String toString() {
      return String.format("%d개 일치 (%d원)", sameCount, amount);
    }
  }

  protected final Grade grade;

  public LottoStat(Grade grade) {
    this.grade = grade;
  }

  public int total() {
    return grade.getAmount() * getCount();
  }

  abstract int getCount();

  abstract void decide(int sameNumberCount);
}
