package lotto.view;

import lotto.domain.Rank;
import lotto.domain.WinningResult;

public class ResultView {

    public static final String WINNUNG_NUMERICAL_SATATEMENT = "당첨 통계";
    public static final String DIVIDING_LINE = "--------";

    public static void printWinningNumericalStatement() {
        System.out.println(WINNUNG_NUMERICAL_SATATEMENT);
        System.out.println(DIVIDING_LINE);
    }

    public static void printLottoResult(WinningResult winningResult) {
        System.out.println("3개 일치 (" + Rank.FOURTH.getWinningMoney() + "원)- " + winningResult.getWinningResult(Rank.FOURTH) + "개");
        System.out.println("4개 일치 (" + Rank.THIRD.getWinningMoney() + "원)- " + winningResult.getWinningResult(Rank.THIRD) + "개");
        System.out.println("5개 일치 (" + Rank.SECOND.getWinningMoney() + "원)- " + winningResult.getWinningResult(Rank.SECOND) + "개");
        System.out.println("6개 일치 (" + Rank.FIRST.getWinningMoney() + "원)- " + winningResult.getWinningResult(Rank.FIRST) + "개");
    }

}
