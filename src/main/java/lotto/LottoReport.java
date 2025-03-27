package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoReport {

  private static final String TOTAL_PRIZE_RATE_FORMAT = "총 수익률은 %.2f입니다.";

  private final LottoReward lottoReward;
  private final PurchaseAmount purchaseAmount;

  public LottoReport(PurchaseAmount purchaseAmount, WinningLotto winningLotto, Lottos lottos) {
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
    return String.format("%s- %d개", prize.getDisplayText(), count);
  }

  public String createMoneyReport() {
    int totalMoney = lottoReward.calculateTotalWinningMoney();
    double totalRevenue = purchaseAmount.calculateProfitRate(totalMoney);
    return String.format(TOTAL_PRIZE_RATE_FORMAT, totalRevenue);
  }
}