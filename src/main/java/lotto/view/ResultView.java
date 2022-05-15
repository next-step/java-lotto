package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.domain.Winnings;

public class ResultView {
    public static void resultLottoNumber(int numberOfLotto, Lottos lottos) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        System.out.println(lottos.toString());

    }

    public static void resultWinners(WinningNumbers winningNumbers) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println(winningNumbers.toString());
    }

    public static void resultRevenue(WinningNumbers winningNumbers, int money) {
        double revenue = winningNumbers.revenue(money);
        System.out.println("총 수익률은 " + revenue + "입니다.(기준이 1이기 때문에 결과적으로 " + winningNumbers.isBenefit(revenue) + "(이)라는 의미임)");

    }
}
