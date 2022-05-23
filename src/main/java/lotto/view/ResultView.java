package lotto.view;

import lombok.extern.slf4j.Slf4j;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winners;
import lotto.domain.WinningsType;

import java.util.Map;

public class ResultView {
    public static final String RESULT_LOSS = "손해";
    private static final String RESULT_BREAK_EVEN = "본전";
    private static final String RESULT_PROFIT = "이득";
    private static final int PROFIT_STANDARD = 1;
    private static final int ZERO = 0;

    private ResultView() {
    }

    public static void resultLottoNumber(int numberOfLotto, Lottos lottos) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void resultWinners(Winners winners) {
        Map<WinningsType, Integer> winnerResult = winners.getWinners();
        System.out.println("\n당첨 통계\n---------");
        for (WinningsType winningsType : winnerResult.keySet()) {
            resultWinner(winningsType, winnerResult);
        }
    }

    private static void resultWinner(WinningsType winningsType, Map<WinningsType, Integer> winnerResult) {
        int key = winningsType.getNumberOfSame();
        int value = winnerResult.get(winningsType);

        if (key == ZERO) {
            return;
        }

        if (isBonusWinnings(winningsType)) {
            System.out.println(key + "개 일치, 보너스 볼 일치 (" + winningsType.getWinnings() + "원)- " + value + "개");
            return;
        }

        System.out.println(key + "개 일치 (" + winningsType.getWinnings() + "원)- " + value + "개");
    }

    private static boolean isBonusWinnings(WinningsType winningsType) {
        return winningsType.equals(WinningsType.이등);
    }

    public static void resultProfit(Winners winners, int money) {
        double revenue = winners.revenue(money);
        String result = resultProfit(revenue);

        System.out.println("총 수익률은 " + String.format(" %.2f", revenue) + "입니다.(기준이 1이기 때문에 결과적으로 " + result + "(이)라는 의미임)");
    }

    private static String resultProfit(double revenue) {
        if (revenue > PROFIT_STANDARD) {
            return RESULT_PROFIT;
        }
        if (revenue < PROFIT_STANDARD) {
            return RESULT_LOSS;
        }
        return RESULT_BREAK_EVEN;
    }

}
