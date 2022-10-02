package lotto.controller;


import lotto.model.Lotto;
import lotto.model.LottoBall;
import lotto.model.Lottos;
import lotto.model.MatchNumber;

import java.util.Map;
import java.util.stream.Collectors;

public abstract class OutputView {
    private static final String RESULT_MSG = "당첨 통계\n---------";
    private static final String BASE_SUMMARY_FORMAT = "%d 개 일치 %s(%d원) - %d개 \n";
    private static final String PROFIT_MSG = "총 수익율은 %.2f 입니다.";

    private static final String BONUS_BALL_MATCH_MSG = ", 보너스 볼 일치";
    private static final String EMPTY_MSG = "";

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .map(Lotto::getLotto)
                .map((ball) -> ball.stream()
                        .map(LottoBall::getNum)
                        .collect(Collectors.toList())).forEach(System.out::println);
    }

    public static void printSummary(Map<MatchNumber, Integer> map) {
        System.out.println(RESULT_MSG);
        map.forEach((k, v) -> printByBonusBall(k, v));
    }

    private static void printByBonusBall(MatchNumber k, Integer v) {
        if (k.equals(MatchNumber.NONE)) {
            return;
        }
        if (k.equals(MatchNumber.SECOND)) {
            printSummary(k.getCount(), k.getMoney(), BONUS_BALL_MATCH_MSG, v);
            return;
        }
        printSummary(k.getCount(), k.getMoney(), EMPTY_MSG, v);
    }

    private static void printSummary(Integer matchNumbers, Integer price, String message, Integer count) {
        System.out.printf(BASE_SUMMARY_FORMAT, matchNumbers, message, price, count);
    }

    public static void printProfit(float result) {
        System.out.printf(PROFIT_MSG, result);
    }
}
