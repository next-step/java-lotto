package lotto.step2.view;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoBoard;
import lotto.step2.domain.Lottos;
import lotto.step2.domain.enums.LottoBoardMatcher;

public class ResultView {

    private static final String PURCHASE_MSG = "개를 구매했습니다.";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String NEWLINE_CHARACTER = "\n";
    private static final String FRONT_BRACKETS = "[";
    private static final String END_BRACKETS = "]";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String BOUNDARY = "---------";
    private static final String WINNING_MATCH_MSG = "%d개 일치 (%d)원 - %d개";
    private static final String WINNING_RATIO = "총 수익률은 %.02f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {
    }

    public static void printPurchaseAmount(int amount) {
        System.out.println(amount + PURCHASE_MSG);
    }

    public static void printLottos(Lottos lottos) {
        String lottoList = lottos.stream()
                .map(ResultView::lottoToString)
                .collect(Collectors.joining());

        System.out.println(lottoList);
    }

    private static String lottoToString(Lotto lotto) {
        return FRONT_BRACKETS + lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER))
                + END_BRACKETS + NEWLINE_CHARACTER;
    }

    public static void printLottoResult(LottoBoard lottoBoard) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(BOUNDARY);

        Map<Long, Long> map = lottoBoard.stream().collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting())
        );

        LongStream.rangeClosed(LottoBoardMatcher.THREE.getMatchCount(), LottoBoardMatcher.SIX.getMatchCount())
            .forEach(matchCount -> {
                System.out.println(String.format(WINNING_MATCH_MSG, matchCount, LottoBoardMatcher.getWinningBonus(matchCount), valueToLong(map, matchCount)));
            }
        );

        System.out.println(String.format(WINNING_RATIO, LottoBoardMatcher.winningRatio(map)));
    }

    private static Long valueToLong(Map<Long, Long> map, Long key) {
        Long value = map.get(key);
        if (value == null) {
            return 0L;
        }
        return value;
    }
}
