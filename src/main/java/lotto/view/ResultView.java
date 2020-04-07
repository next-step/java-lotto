package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Winning;

import java.util.Map;

public class ResultView {
    private static final String PURCHASED_NUM_NOTICE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBER_FORMAT = "[%s]\n";
    private static final String RESULT_STATISTIC_NOTICE = "\n당첨 통계\n---------\n";
    private static final String RESULT_COUNT_FORMAT = "%d개 일치 (%d원)- %d개\n";
    private static final String RESULT_YIELD_LOSE_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";
    private static final String RESULT_YIELD_WIN_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)\n";

    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    public static void printIssuedLotto(Lottos issuedlotto) {
        StringBuffer stringBuffer = new StringBuffer(String.format(PURCHASED_NUM_NOTICE, issuedlotto.size()));

        stringBuffer.append(issuedlotto.toString(LOTTO_NUMBER_FORMAT, LOTTO_NUMBER_DELIMITER));

        System.out.println(stringBuffer.toString());
    }

    public static void printLottoResult(Map<Winning, Integer> result, int paidMoney) {
        StringBuilder stringBuilder = new StringBuilder(RESULT_STATISTIC_NOTICE);

        int winningPrice = 0;
        for (Winning winning : Winning.winValues()) {
            int matchCount = result.getOrDefault(winning, 0);

            stringBuilder.append(String.format(RESULT_COUNT_FORMAT, winning.getMatchCount(), winning.getWinningPrice(), matchCount));

            winningPrice += winning.calculatePrice(matchCount);
        }
        stringBuilder.append(getYieldResult((float) winningPrice / (float) paidMoney));


        System.out.println(stringBuilder.toString());
    }

    private static String getYieldResult(float yield) {
        if (yield > 1) {
            return String.format(RESULT_YIELD_WIN_FORMAT, yield);
        }

        return String.format(RESULT_YIELD_LOSE_FORMAT, yield);
    }
}
