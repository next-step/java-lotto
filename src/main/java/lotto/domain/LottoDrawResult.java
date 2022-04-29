package lotto.domain;

public class LottoDrawResult {

  private final int matchCount;
  private final int reword;

  public LottoDrawResult(int matchCount, int reword) {
    this.matchCount = matchCount;
    this.reword = reword;
  }

  public int getReword() {
    return reword;
  }

  public boolean isMatchCountEqual(int matchCount) {
    return this.matchCount == matchCount;
  }
}
