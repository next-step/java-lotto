package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

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


    /*
    @Override
    public String toString() {
        String resultString = "";
        for (String winner : winners.keySet()) {
            resultString += winner + " 일치 (" + Winnings.selectWinnings(winner) + "원)- " + winners.get(winner) + "개" + "\n";
        }

        return resultString.substring(FIRST_STRING, resultString.length() - FINAL_LINE_BREAK);
    }
     */
}
