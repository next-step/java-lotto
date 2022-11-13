package nextstep.lotto;
public class LottoGame {
  private final Lotto winning;

  public LottoGame(final Lotto winning) {
    this.winning = winning;
  }

  public LottoResult match(final Lotto lotto) {
    final int matchCount = lotto.match(winning);
    return LottoResult.lottoResult(matchCount);
  }
}
