package lotto.view;

import lotto.domain.EarnRate;
import lotto.domain.Lotto;
import lotto.domain.Lottoes;
import lotto.domain.Prize;

public class OutputView {

    protected static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    protected static final String STATISTICS_MESSAGE = "당첨 통계\n---------";

    protected static final String EARN_RATE_MESSAGE = "총 수익률은 %.2f입니다.(%s)";

    public void showPurchaseCount(int count) {
        System.out.println(count + PURCHASE_MESSAGE);
    }

    public void showPurchasedLottoes(Lottoes lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showStatistics(int purchaseCount) {
        System.out.println(STATISTICS_MESSAGE);
        showMatchingCount();
        showEarningRate(purchaseCount);
    }

    protected void showMatchingCount() {
        for (Prize prize : Prize.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", prize.getMatchCount()
                    , prize.getPrize()
                    , prize.getPrizeCount());
        }
    }

    protected void showEarningRate(int purchaseAmount) {
        double earnRate = Prize.calculateEarningRate(purchaseAmount);
        System.out.printf(EARN_RATE_MESSAGE, earnRate, EarnRate.getExplanationMessage(earnRate));
    }
}
