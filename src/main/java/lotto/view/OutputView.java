package lotto.view;

import lotto.domain.EarnRate;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottoes;
import lotto.domain.Rank;

public final class OutputView {

    private static final String PURCHASE_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";

    private static final String STATISTICS_MESSAGE = "당첨 통계\n---------";

    private static final String EARN_RATE_MESSAGE = "총 수익률은 %.2f입니다.(%s)";

    private static final String DEFAULT_STATISTICS_MESSAGE = "%d개 일치 (%d원) - %d개\n";

    private static final String SECOND_STATISTICS_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";

    public void showPurchaseCount(final int manualLottoCount, final int automaticLottoCount) {
        System.out.printf(PURCHASE_MESSAGE, manualLottoCount, automaticLottoCount);
    }

    public void showPurchasedLottoes(final Lottoes lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showStatistics(final LottoResult lottoResult, final int paid) {
        System.out.println(STATISTICS_MESSAGE);
        showMatchingCounts(lottoResult);
        showEarnRate(lottoResult, paid);
    }

    private void showMatchingCounts(LottoResult lottoResult) {
        for (Rank rank : Rank.values()) {
            showMatchingCount(lottoResult, rank);
        }
    }

    private void showMatchingCount(LottoResult lottoResult, Rank rank) {
        String message = DEFAULT_STATISTICS_MESSAGE;

        if (rank.equals(Rank.SECOND)) {
            message = SECOND_STATISTICS_MESSAGE;
        }

        System.out.printf(message, rank.getMatchCount()
                , rank.getPrize()
                , lottoResult.getManualWinningCount().getMatchCount(rank) +
                        lottoResult.getAutoWinningCount().getMatchCount(rank));
    }

    private void showEarnRate(LottoResult lottoResult, int paid) {
        double earn = lottoResult.calculateEarn(paid);

        System.out.printf(EARN_RATE_MESSAGE, earn, EarnRate.getExplanationMessage(earn));
    }
}
