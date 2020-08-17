package step2;

public enum LottoRank {
  First(6, false, 2_000_000_000),
  Second(5, true, 30_000_000),
  Third(5, false, 1_500_000),
  Fourth(4, false, 50_000),
  Fifth(3, false, 5_000);

  private final int matchCount;
  private final boolean hasBonusNumber;
  private final int amount;

  LottoRank(int matchCount, boolean hasBonusNumber, int amount) {
    this.matchCount = matchCount;
    this.hasBonusNumber = hasBonusNumber;
    this.amount = amount;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getAmount() {
    return amount;
  }

  public boolean isWin(int matchCount, boolean hasBonusNumber) {
    return this.matchCount == matchCount && this.hasBonusNumber == hasBonusNumber;
  }

  @Override
  public String toString() {
    if (this == LottoRank.Second) return String.format("%d개 일치, 보너스 볼 일치(%d원)", matchCount, amount);

    return String.format("%d개 일치 (%d원)", matchCount, amount);
  }
}
