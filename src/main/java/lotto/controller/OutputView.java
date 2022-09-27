package lotto.controller;


import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.MatchNumber;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String RESULT_MSG = "당첨 통계\n---------";
    private static final String BASE_SUMMARY_FORMAT = "%d 개 일치 (%d원) - %d개 \n";
    private static final String PROFIT_MSG = "총 수익율은 %.2f 입니다.";

    static void printLottos(Lottos lottos) {
        lottos.getLottos().stream().map(Lotto::getLotto).forEach(System.out::println);
    }

    public static void printSummary(Map<MatchNumber, Long> map) {
        System.out.println(RESULT_MSG);
        map.forEach((k, v) -> System.out.printf(BASE_SUMMARY_FORMAT, k.getCount(), k.getMoney(), v));
    }

    public static void printProfit(float result) {
        System.out.printf(PROFIT_MSG,result);
    }
}
