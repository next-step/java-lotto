package step2;

public enum LottoRank {
  First(6, 2000000000),
  Second(5, 1500000),
  Third(4, 50000),
  Fourth(3, 5000);

  private int matchCount;
  private int amount;

  LottoRank(int matchCount, int amount) {
    this.matchCount = matchCount;
    this.amount = amount;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getAmount() {
    return amount;
  }

  public boolean ismMatchCount(int sameCount) {
    return this.matchCount == sameCount;
  }

  @Override
  public String toString() {
    return String.format("%d개 일치 (%d원)", matchCount, amount);
  }
}
