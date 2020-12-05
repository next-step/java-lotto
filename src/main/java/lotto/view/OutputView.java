package lotto.view;

import lotto.domain.EarnRate;
import lotto.domain.Lotto;
import lotto.domain.Lottoes;
import lotto.domain.Rank;
import lotto.domain.WinningCount;

public final class OutputView {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    private static final String STATISTICS_MESSAGE = "당첨 통계\n---------";

    private static final String EARN_RATE_MESSAGE = "총 수익률은 %.2f입니다.(%s)";

    private static final String DEFAULT_STATISTICS_MESSAGE = "%d개 일치 (%d원) - %d개\n";

    private static final String SECOND_STATISTICS_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";

    public void showPurchaseCount(final int count) {
        System.out.println(count + PURCHASE_MESSAGE);
    }

    public void showPurchasedLottoes(final Lottoes lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showStatistics(final WinningCount winningCount, final int paid) {
        System.out.println(STATISTICS_MESSAGE);
        showMatchingCounts(winningCount);
        showEarnRate(winningCount, paid);
    }

    private void showMatchingCounts(final WinningCount winningCount) {
        for (Rank rank : Rank.values()) {
            showMatchingCount(winningCount, rank);
        }
    }

    private void showMatchingCount(final WinningCount winningCount, final Rank rank) {
        String message = DEFAULT_STATISTICS_MESSAGE;

        if (rank.equals(Rank.SECOND)) {
            message = SECOND_STATISTICS_MESSAGE;
        }

        System.out.printf(message, rank.getMatchCount()
                , rank.getPrize()
                , winningCount.getMatchCount(rank));
    }

    private void showEarnRate(final WinningCount winningCount, final int paid) {
        double earn = winningCount.calculateEarnRate(paid);
        System.out.printf(EARN_RATE_MESSAGE, earn, EarnRate.getExplanationMessage(earn));
    }
}
