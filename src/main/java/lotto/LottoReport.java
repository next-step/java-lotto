package lotto;

import lotto.domain.prize.LottoPrize;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.prize.LottoReward;
import lotto.view.ResultView;

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
      countReportContent.add(ResultView.getPrizeAndCountStatus(prize, count));
    }
    return String.join("\n", countReportContent);
  }

  public String createMoneyReport() {
    int totalMoney = lottoReward.calculateTotalWinningMoney();
    double totalRevenue = purchaseAmount.calculateProfitRate(totalMoney);
    return String.format(TOTAL_PRIZE_RATE_FORMAT, totalRevenue);
  }
}