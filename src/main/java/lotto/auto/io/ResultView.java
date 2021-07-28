package lotto.auto.io;

import lotto.auto.model.LottoGame;
import lotto.auto.model.Rank;

import java.util.List;
import java.util.Map;

import static lotto.auto.context.ConstantContext.*;

public final class ResultView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DISPLAY_PURCHASES_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계" + NEW_LINE + "---------";
    private static final String PRIZE_RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String EARNINGS_RATE_FORMAT = "총 수익률은 %.2f입니다.";

    private ResultView() {
    }

    public static void printGameCount(final int money) {
        println(String.format(DISPLAY_PURCHASES_COUNT_FORMAT, money / GAME_PRICE));
    }

    public static void printGame(final List<LottoGame> lottoGames) {
        for (LottoGame lottoGame : lottoGames) {
            println(lottoGame.toString());
        }
    }

    public static void printStatistic(final Map<String, Object> result) {
        int[] matchTable = (int[]) result.get(MATCH_TABLE_KEY);
        double earningsRate = (double) result.get(EARNINGS_RATE_KEY);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 3; i <= 6; i++) {
            stringBuilder.append(String.format(PRIZE_RESULT_FORMAT, i, Rank.findPrizeMoneyByMatchCount(i), matchTable[i]));
            stringBuilder.append(NEW_LINE);
        }
        stringBuilder.append(String.format(EARNINGS_RATE_FORMAT, earningsRate));

        println("");

        println(WINNING_STATISTICS_MESSAGE);
        println(stringBuilder.toString());
    }

    private static void println(String string) {
        System.out.println(string);
    }
}
