package lotto.view;

import lotto.domain.Rank;
import lotto.domain.WinningResult;

import static lotto.utils.CommonConstant.NUMBER_ONE;

public class ResultView {

    private static final String WINNUNG_NUMERICAL_SATATEMENT = "당첨 통계";
    private static final String DIVIDING_LINE = "--------";
    private static final String PRINT_RATE_OF_RETURN_START = "총 수익률은 ";
    private static final String PRINT_RATE_OF_RETURN_END = "입니다.";
    private static final String LOSS = "손해";
    private static final String PROFIT = "이익";
    private static final String PRINT_LOTTO_RESULT_START = "(기준이 1이기 때문에 결과적으로 ";
    private static final String PRINT_LOTTO_RESULT_END = "라는 의미임)";

    public static void printWinningNumericalStatement() {
        System.out.println(WINNUNG_NUMERICAL_SATATEMENT);
        System.out.println(DIVIDING_LINE);
    }

    public static void printLottoResult(WinningResult winningResult) {
        System.out.println("3개 일치 (" + Rank.FIFTH.getWinningMoney() + "원)- " + winningResult.getWinningResult(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (" + Rank.FOURTH.getWinningMoney() + "원)- " + winningResult.getWinningResult(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (" + Rank.THIRD.getWinningMoney() + "원)- " + winningResult.getWinningResult(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(" + Rank.SECOND.getWinningMoney() + "원)- " + winningResult.getWinningResult(Rank.SECOND) + "개");
        System.out.println("6개 일치 (" + Rank.FIRST.getWinningMoney() + "원)- " + winningResult.getWinningResult(Rank.FIRST) + "개");
    }

    public static void printRateOfReturn(String rateOfReturn, double profitBaseValue) {
        System.out.print(PRINT_RATE_OF_RETURN_START + rateOfReturn + PRINT_RATE_OF_RETURN_END);
        System.out.println(PRINT_LOTTO_RESULT_START + getIdentifyCriteria(profitBaseValue) + PRINT_LOTTO_RESULT_END);
    }

    private static String getIdentifyCriteria(double profitBaseValue) {
        if (profitBaseValue >= NUMBER_ONE) {
            return PROFIT;
        }
        return LOSS;
    }

}
