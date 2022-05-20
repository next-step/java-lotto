package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winners;
import lotto.domain.WinningsType;

import java.util.Map;

public class ResultView {
    public static final String RESULT_LOSS = "손해";
    private static final String RESULT_BREAK_EVEN = "본전";
    private static final String RESULT_PROFIT = "이득";

    private ResultView() {
    }

    public static void resultLottoNumber(int numberOfLotto, Lottos lottos) {
        String resultString = "";
        for (Lotto lotto : lottos.getLottos()) {
            resultString += lotto + "\n";
        }
        System.out.println(numberOfLotto + "개를 구매했습니다.\n" + resultString);
    }

    public static void resultWinners(Winners winners) {
        String resultString = "";
        Map<WinningsType, Integer> winnerResult = winners.getWinners();

        for (WinningsType winningsType : winnerResult.keySet()) {
            int key = winningsType.getNumberOfSame();
            int value = winnerResult.get(winningsType);

            resultString += key + "개 일치 (" + WinningsType.selectWinningsType(key).get().getWinnings() + "원)- " + value + "개" + "\n";
        }

        System.out.println("\n당첨 통계\n---------\n" + resultString);

    }

    private static String resultProfit(double revenue) {
        if (revenue > 1) {
            return RESULT_PROFIT;
        }
        if (revenue < 1) {
            return RESULT_LOSS;
        }
        return RESULT_BREAK_EVEN;
    }

    public static void resultProfit(Winners winners, int money) {
        double revenue = winners.revenue(money);
        String result = resultProfit(revenue);

        System.out.println("총 수익률은 " + revenue + "입니다.(기준이 1이기 때문에 결과적으로 " + result + "(이)라는 의미임)");

    }

}
