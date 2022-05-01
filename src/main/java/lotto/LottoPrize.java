package lotto;

import util.LottoOutputView;

public enum LottoPrize {
  THREE(3, 5000, "3개 일치 (%s원)- %s개"),
  FOUR(4, 50000, "4개 일치 (%s원)- %s개"),
  FIVE(5, 1500000, "5개 일치 (%s원)- %s개"),
  SIX(6, 2000000000, "6개 일치 (%s원)- %s개");

  private final int matched;
  private final int revenue;
  private final String revenueMessageToPrint;


  LottoPrize(int matched, int revenue, String resultMessage) {
    this.matched = matched;
    this.revenue = revenue;
    this.revenueMessageToPrint = resultMessage;
  }

  public int getMatchedLottoCount(Lotto winningLotto, LottoList lottoList) {
    return lottoList.getMatchedLottoCount(matched, winningLotto);
  }

  public int getRevenue(int matchedLottoCount) {
    return matchedLottoCount * revenue;
  }

  public void printingRevenue(int matchedLottoCount) {
    LottoOutputView.print(String.format(revenueMessageToPrint, revenue, matchedLottoCount));
  }
}
