package lotto.view;

import lotto.domain.EarnRate;
import lotto.domain.Lotto;
import lotto.domain.Lottoes;
import lotto.domain.Rank;
import lotto.domain.WinningCount;
import lotto.domain.WinningRecord;

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

    public void showStatistics(WinningCount winningCount, int paid) {
        System.out.println(STATISTICS_MESSAGE);
        showMatchingCount(winningCount);
        showEarnRate(winningCount, paid);
    }

    protected void showMatchingCount(WinningCount winningCount) {
        for (Rank rank : Rank.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", rank.getMatchCount()
                    , rank.getPrize()
                    , winningCount.getMatchCount(rank.getMatchCount()));
        }
    }

    private void showEarnRate(WinningCount winningCount, int paid) {
        double earn = winningCount.calculateEarnRate(paid);
        System.out.printf(EARN_RATE_MESSAGE, earn, EarnRate.getExplanationMessage(earn));
    }
}
