package lotto.view;

import lotto.domain.*;

import java.util.Map;

public class ResultView {
    public static final String RESULT_LOSS = "손해";
    private static final String RESULT_BREAK_EVEN = "본전";
    private static final String RESULT_PROFIT = "이득";
    private static final String ENTER = "\n";
    private static final int PROFIT_STANDARD = 1;
    private static final int ZERO = 0;
    private static final int LAST_NUMBER_FORMAT = 2;

    private ResultView() {
    }

    public static void resultLotto(int manualSize, int numberOfLotto, Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ENTER);
        stringBuilder.append("수동으로 " + manualSize + "장, 자동으로 " + (numberOfLotto - manualSize) + "개를 구매했습니다.").append(ENTER);
        for (Lotto lotto : lottos.getLottos()) {
            resultLottoNumber(lotto, stringBuilder);
        }
        System.out.print(stringBuilder);
    }

    private static void resultLottoNumber(Lotto lotto, StringBuilder stringBuilder) {
        stringBuilder.append("[");
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            stringBuilder.append(lottoNumber.getLottoNumber() + ", ");
        }
        stringBuilder.delete(stringBuilder.length() - LAST_NUMBER_FORMAT, stringBuilder.length());
        stringBuilder.append("]").append(ENTER);
    }

    public static void resultWinners(Winners winners) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Rank, Integer> winnerResult = winners.getWinners();
        stringBuilder.append(ENTER);
        stringBuilder.append("당첨 통계").append(ENTER);
        stringBuilder.append("---------").append(ENTER);
        for (Rank winningsType : winnerResult.keySet()) {
            resultWinner(stringBuilder, winningsType, winnerResult);
        }
        System.out.println(stringBuilder);
    }

    private static void resultWinner(StringBuilder stringBuilder, Rank
            winningsType, Map<Rank, Integer> winnerResult) {
        int key = winningsType.getNumberOfSame();
        int value = winnerResult.get(winningsType);
        if (key == ZERO) {
            return;
        }
        if (isBonusWinnings(winningsType)) {
            stringBuilder.append(key + "개 일치, 보너스 볼 일치 (" + winningsType.getWinnings() + "원)- " + value + "개").append(ENTER);
            return;
        }
        stringBuilder.append(key + "개 일치 (" + winningsType.getWinnings() + "원)- " + value + "개").append(ENTER);
    }

    private static boolean isBonusWinnings(Rank winningsType) {
        return winningsType.equals(Rank.이등);
    }

    public static void resultProfit(Winners winners, int money) {
        double revenue = winners.revenue(money);
        System.out.println("총 수익률은 " + String.format(" %.2f", revenue) + "입니다.(기준이 1이기 때문에 결과적으로 " + resultProfit(revenue) + "(이)라는 의미임)");
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
