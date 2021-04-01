/*
 * UI 출력을 담당하는 클래스
 * */
package lotto.ui;

import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

import java.util.Map;

public class ResultView {

    public static final String RESULT_MESSAGE = "당첨 통계";
    public static final String RESULT_MESSAGE_LINE = "---------";
    public static final String YIELD_MESSAGE_BEFORE = "총 수익률은 ";
    public static final String YIELD_MESSAGE_AFTER = " 입니다.";
    public static final String YIELD_DECIMAL_PLACE = "%.2f";
    public static final String YIELD_MESSAGE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String YIELD_MESSAGE_PROFIT = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    public static final int YIELD_BOUND = 1;


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
                .filter(ResultView::checkResultBound)
                .forEach(ResultView::printRank);
    }

    /*
    * 수익률을 출력한다.
    * */
    public static void printYield(double yield) {
        System.out.print(YIELD_MESSAGE_BEFORE + String.format(YIELD_DECIMAL_PLACE, yield) + YIELD_MESSAGE_AFTER);
        if (yield <= YIELD_BOUND) {
            System.out.print(YIELD_MESSAGE_LOSS);
            return;
        }
        System.out.print(YIELD_MESSAGE_PROFIT);
    }

    /*
    * 당첨인 경우만 출력한다.
    * */
    public static boolean checkResultBound(Map.Entry<Rank, Integer> entry) {
        if (entry.getKey() != Rank.MISS) {
            return true;
        }
        return false;
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
