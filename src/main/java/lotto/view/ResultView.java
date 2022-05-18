package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Winners;
import lotto.domain.WinningsType;

public class ResultView {
    public static final int STRING_INITIAL = 1;
    public static final int STRING_LAST = 1;
    public static final int LAST_BRACKET_NUMBER = 3;

    private ResultView() {
    }

    public static void resultLottoNumber(int numberOfLotto, Lottos lottos) {
        String[] results = lottos.toString().split("], ");
        String resultString = "";
        for (String result : results) {
            resultString += result + "]\n";
        }
        System.out.println(numberOfLotto + "개를 구매했습니다.\n" + resultString.substring(STRING_INITIAL, resultString.length() - LAST_BRACKET_NUMBER) + "\n");
    }

    public static void resultWinners(Winners winners) {
        String resultString = "";
        String[] results = winners.toString().substring(STRING_INITIAL, winners.toString().length() - STRING_LAST).split(", ");

        for (String result : results) {
            int key = WinningsType.selectNumberOfSame(result.substring(0, 2));
            String valueString = result.substring(3);
            resultString += key + "개 일치 (" + WinningsType.selectWinnings(key) + "원)- " + valueString + "개" + "\n";
        }

        System.out.println("\n당첨 통계\n---------\n" + resultString);

    }

    public static void resultRevenue(Winners winners, int money) {
        double revenue = winners.revenue(money);
        System.out.println("총 수익률은 " + revenue + "입니다.(기준이 1이기 때문에 결과적으로 " + winners.isBenefit(revenue) + "(이)라는 의미임)");

    }
}
