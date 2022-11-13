package nextstep.lotto.domain;

public class LottoWinCount {

  private final LottoResult grade;
  private final long count;

  public LottoWinCount(LottoResult grade, long count) {
    this.grade = grade;
    this.count = count;
  }

  public LottoResult result() {
    return grade;
  }

  public long count() {
    return count;
  }
}
