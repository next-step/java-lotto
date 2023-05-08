package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String BUY_COUNT_FORMAT = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    private static final String WIN_RESULT_FORMAT = "%s개 일치 (%s원) - %s개";
    private static final String WIN_BONUS_RESULT_FORMAT = "%s개 일치, 보너스 볼 일치 (%s원) - %s개";
    private static final String RATE_OF_RESULT_FORMAT = "총 수익률은 %.2f입니다.";

    private static final String RESULT_NOTICE_MENT = "당첨 통계";
    private static final String LINE_SEPARATOR = "---------";
    private static final String LOTTO_NUMBER_START_SEPARATOR = "[";
    private static final String LOTTO_NUMBER_END_SEPARATOR = "]";
    private static final String LOTTO_NUMBER_SEPARATOR = ", ";

    private ResultView() {
    }

    public static void buyResultNotice(final List<Lotto> lottos, final int manuallyBuyCount, final int automaticallyBuycount) {
        System.out.println(String.format(BUY_COUNT_FORMAT, manuallyBuyCount, automaticallyBuycount));
        for (Lotto lotto : lottos) {
            System.out.println(
                    LOTTO_NUMBER_START_SEPARATOR + lottoFormat(lotto) + LOTTO_NUMBER_END_SEPARATOR
            );
        }
        System.out.println();
    }

    public static void winResultNotice(final WinResult winResult) {
        System.out.println();
        System.out.println(RESULT_NOTICE_MENT);
        System.out.println(LINE_SEPARATOR);
        System.out.println(rankFormat(Rank.FIFTH, winResult));
        System.out.println(rankFormat(Rank.FOURTH, winResult));
        System.out.println(rankFormat(Rank.THIRD, winResult));
        System.out.println(rankFormat(Rank.SECOND, winResult));
        System.out.println(rankFormat(Rank.FIRST, winResult));
        System.out.println(String.format(RATE_OF_RESULT_FORMAT, winResult.rateOfResult()));
    }

    private static String rankFormat(final Rank rank, final WinResult winResult) {
        if (rank == Rank.SECOND) {
            return String.format(WIN_BONUS_RESULT_FORMAT, rank.matchCount(), rank.winnings(), winResult.winCount(rank));
        }
        return String.format(WIN_RESULT_FORMAT, rank.matchCount(), rank.winnings(), winResult.winCount(rank));
    }

    private static String lottoFormat(final Lotto lotto) {
        return lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(LOTTO_NUMBER_SEPARATOR));
    }
}
