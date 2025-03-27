package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class LottoReport {

  private static final String TOTAL_PRIZE_RATE_FORMAT = "총 수익률은 %.2f입니다.";
  private static final String TOTAL_COUNT_FORMAT = "%d개 일치 (%d원)- %d개";

  private final LottoReward lottoReward;
  private final PurchaseAmount purchaseAmount;

  public LottoReport(PurchaseAmount purchaseAmount, Lotto winningLotto, Lottos lottos, LottoNumber bonusNumber) {
    this.lottoReward = new LottoReward(lottos, winningLotto, bonusNumber);
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