package view;

import domain.LottoResult;
import domain.Rank;

import java.math.BigDecimal;
import java.util.List;

public class ResultView {
    private static final String MESSAGE_MANUAL_COUNT = "수동으로 ";
    private static final String MESSAGE_AUTO_COUNT = "장, 자동으로 ";
    private static final String MESSAGE_LOTTO_COUNT = "개를 구매했습니다";
    private static final String MESSAGE_STATISTIC = "당첨 통계";
    private static final String MESSAGE_STATISTIC_LINE = "---------";
    private static final String MESSAGE_MATCH_IS = "개 일치";
    private static final String MESSAGE_WON = "원";
    private static final String MESSAGE_BONUS_MATCH = ", 보너스 볼 일치";
    private static final String MESSAGE_MATCH_COUNT = "개";
    private static final String MESSAGE_RATIO_RESULT = "총 수익률은 ";
    private static final String MESSAGE_RATIO_RESULT_END = "입니다.";

    public void printLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println("\n" + MESSAGE_MANUAL_COUNT + manualLottoCount
                + MESSAGE_AUTO_COUNT + autoLottoCount + MESSAGE_LOTTO_COUNT);
    }

    public void printAllLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printResultStatistic(LottoResult lottoResult) {
        System.out.println("\n" + MESSAGE_STATISTIC + "\n" + MESSAGE_STATISTIC_LINE);

        for (Rank rank : Rank.values()) {
            printRank(rank, lottoResult);
        }
    }

    public void printResultRatio(BigDecimal prizeRatio) {
        System.out.println(MESSAGE_RATIO_RESULT + prizeRatio + MESSAGE_RATIO_RESULT_END);
    }

    private void printRank(Rank rank, LottoResult lottoResult) {
        if (rank == Rank.FAIL) {
            return;
        }
        if (rank == Rank.SECOND) {
            printBonusRank(rank, lottoResult);
            return;
        }
        System.out.println(rank.getMatchCount() + MESSAGE_MATCH_IS
                + " (" + rank.getPrize() + MESSAGE_WON + ")- "
                + lottoResult.getRankCount(rank) + MESSAGE_MATCH_COUNT);
    }

    private void printBonusRank(Rank rank, LottoResult lottoResult) {
        System.out.println(rank.getMatchCount() + MESSAGE_MATCH_IS + MESSAGE_BONUS_MATCH
                + " (" + rank.getPrize() + MESSAGE_WON + ")- "
                + lottoResult.getRankCount(rank) + MESSAGE_MATCH_COUNT);
    }

}
