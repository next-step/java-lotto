package lotto.domain;

public class LottoDrawResult {

  private final int matchCount;
  private final int reword;
  private final boolean isBonusMatch;

  public LottoDrawResult(int matchCount, int reword, boolean isBonusMatch) {
    this.matchCount = matchCount;
    this.reword = reword;
    this.isBonusMatch = isBonusMatch;
  }

  public int getReword() {
    return reword;
  }

  public boolean isBonusMatch() {
    return isBonusMatch;
  }

  public boolean isMatchCountEqual(int matchCount) {
    return this.matchCount == matchCount;
  }
}
