package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoReport {

  private static final String TOTAL_PRIZE_RATE_FORMAT = "총 수익률은 %.2f입니다.";
  private static final String TOTAL_COUNT_FORMAT = "%d개 일치 (%d원)- %d개";

  private final LottoReward lottoReward;
  private final PurchaseAmount purchaseAmount;

  public LottoReport(PurchaseAmount purchaseAmount, Lotto winningLotto, Lottos lottos) {
    this.lottoReward = new LottoReward(lottos, winningLotto);
    this.purchaseAmount = purchaseAmount;
  }

  public String createCountReport() {
    List<String> countReportContent = new ArrayList<>();

    for (LottoPrize prize : LottoPrize.values()) {
      int count = lottoReward.getPrizeCount(prize);
      countReportContent.add(getPrizeAndCountStatus(prize, count));
    }
    return String.join("\n", countReportContent);
  }

  private String getPrizeAndCountStatus(LottoPrize prize, int count) {
    return String.format(TOTAL_COUNT_FORMAT, prize.getMatchCount(), prize.getPrizeMoney(), count);
  }

  public String createMoneyReport() {
    int totalMoney = lottoReward.calculateTotalWinningMoney();
    double totalRevenue = purchaseAmount.calculateProfitRate(totalMoney);
    return String.format(TOTAL_PRIZE_RATE_FORMAT, totalRevenue);
  }
}