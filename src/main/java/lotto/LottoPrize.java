package lotto;

public enum LottoPrize {
  THREE(3, 5000),
  FOUR(4, 5_0000),
  FIVE(5, 150_0000),
  SIX(6, 20_0000_0000);

  private static final String MESSAGE_FOR_MATCHED_LOTTO_COUNT = "%s개 일치 (%s)- %s";

  private final int matchedCount;
  private final int prize;


  LottoPrize(int matched, int prize) {
    this.matchedCount = matched;
    this.prize = prize;
  }

  public int getRevenue(int matchedLottoCount) {
    return prize * matchedLottoCount;
  }

  public String toStringForPrinting(int matchedLottoCount) {
    return String.format(MESSAGE_FOR_MATCHED_LOTTO_COUNT, matchedCount, prize, matchedLottoCount);
  }

  public int getMatchedLottoCount(Lotto winningLotto, LottoList lottoList) {
    return lottoList.getMatchedLottoCount(matchedCount, winningLotto);
  }
}
