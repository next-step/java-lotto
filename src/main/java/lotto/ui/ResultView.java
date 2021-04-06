/*
 * UI 출력을 담당하는 클래스
 * */
package lotto.ui;

import lotto.domain.BuyNumber;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

import java.util.Map;

public class ResultView {

    public static final String BUY_SIZE_MEESAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    public static final String RESULT_MESSAGE = "당첨 통계";
    public static final String RESULT_MESSAGE_LINE = "---------";
    public static final String YIELD_MESSAGE = "총 수익률은 %.2f 입니다.";
    public static final String YIELD_MESSAGE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String YIELD_MESSAGE_PROFIT = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    public static final int YIELD_BOUND = 1;


    public static void printBuySize(BuyNumber buyNumber) {
        System.out.println(String.format(BUY_SIZE_MEESAGE, buyNumber.getManualNumber(), buyNumber.getAutoNumber()));
    }

    /*
     * 로또 목록을 출력한다.
     * */
    public static void printLottos(Lottos lottos) {
        lottos.lottoList().stream()
                .forEach(lotto -> System.out.println(lotto.numbers()));
    }

    /*
     * 당첨통계를 출력한다.
     * */
    public static void printResult(WinningStatistics statistics) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(RESULT_MESSAGE_LINE);
        statistics.winningStatistics().entrySet().stream()
                .filter(e -> Rank.isWinning(e.getKey()))
                .forEach(ResultView::printRank);
    }

    /*
     * 수익률을 출력한다.
     * */
    public static void printYield(double yield) {
        System.out.print(String.format(YIELD_MESSAGE, yield));
        if (yield <= YIELD_BOUND) {
            System.out.print(YIELD_MESSAGE_LOSS);
            return;
        }
        System.out.print(YIELD_MESSAGE_PROFIT);
    }

    /*
     * 당첨 금액과 갯수를 출력한다.
     * */
    public static void printRank(Map.Entry<Rank, Integer> entry) {
        String defaultStr = "개 일치 (";
        if (entry.getKey() == Rank.SECOND) {
            defaultStr = "개 일치, 보너스볼 일치(";
        }
        System.out.println(
                entry.getKey().getMatchNo() + defaultStr + entry.getKey().getWinningMoney() + "원) - "
                        + entry.getValue() + "개"
        );
    }


}
