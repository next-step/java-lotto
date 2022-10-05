package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.enums.Rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ResultView {
    private static final String PURCHASE_RESULT_FORMAT = "%s개를 구매했습니다.";
    private static final String WINNING_STATISTICS_INTRO = "당첨 통계\n---------";
    private static final String WINNING_STATISTICS_FORMAT = "%s개 일치%s(%s원)- %s개";
    private static final String SPACE = " ";
    private static final String BONUS_BALL_MATCHED = ", 보너스 볼 일치";
    private static final String WINNING_STATISTICS_TOTAL_PROFIT_RATE_FORMAT = "총 수익률은 %s (배)입니다.";

    public static void printPurchase(Lottos lottos) {
        System.out.println(String.format(PURCHASE_RESULT_FORMAT, lottos.count()));
        lottos.forEach(lotto -> System.out.println(lotto.numbers()));
    }

    public static void printWinningStatistics(Lottos lottos, Lotto winningLotto, Integer bonusNumber) {
        System.out.println(WINNING_STATISTICS_INTRO);

        List<Rank> ranks = Arrays.stream(Rank.values()).collect(toList());
        Collections.reverse(ranks);
        ranks.forEach(rank -> System.out.println(String.format(WINNING_STATISTICS_FORMAT,
                rank.matchedCount(),
                bonusBallMatchedComment(rank),
                rank.winningAmount(),
                lottos.winningCount(winningLotto, bonusNumber, rank))));

        System.out.println(String.format(WINNING_STATISTICS_TOTAL_PROFIT_RATE_FORMAT,
                lottos.totalProfitRate(winningLotto, bonusNumber)));
    }

    private static String bonusBallMatchedComment(Rank rank) {
        if (Rank.SECOND == rank) {
            return BONUS_BALL_MATCHED;
        }

        return SPACE;
    }
}
