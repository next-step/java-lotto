package lotto.view;

import lotto.domain.Lottos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class OutputView {
    private static final Map<Integer, Integer> WINNING_AMOUNT_MAP = new HashMap<>();
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String SEPARATOR = "---------";
    private static final int START_MATCH_COUNT = 3;
    private static final int END_MATCH_COUNT = 6;

    static {
        WINNING_AMOUNT_MAP.put(3, 5000);
        WINNING_AMOUNT_MAP.put(4, 50000);
        WINNING_AMOUNT_MAP.put(5, 1500000);
        WINNING_AMOUNT_MAP.put(6, 2000000000);
    }

    public static void outputLottoNumbers(Lottos lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.length());
        System.out.println(lottos);
        System.out.println();
    }

    public static void outputWinningStatistics(Lottos lottos, String previousWeekWinningNumber) {
        List<Integer> matchLottos = lottos.findMatch(previousWeekWinningNumber);

        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPARATOR);
        IntStream.rangeClosed(START_MATCH_COUNT, END_MATCH_COUNT)
                .forEach(outputMatchStatistics(matchLottos));
    }

    private static IntConsumer outputMatchStatistics(List<Integer> matchLottos) {
        return i ->
                System.out.printf("%s개 일치 (%s원)- %s\n",
                        i,
                        getWinningAmount(i),
                        getCount(matchLottos, i));
    }

    private static int getCount(List<Integer> matchLottos, int i) {
        return (int) matchLottos.stream()
                .filter(matchLotto -> matchLotto == i)
                .count();
    }

    private static int getWinningAmount(int i) {
        return WINNING_AMOUNT_MAP.get(i);
    }
}
