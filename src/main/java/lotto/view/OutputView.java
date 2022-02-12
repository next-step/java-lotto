package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PrizeGrade;

public class OutputView {

    public static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String REQUEST_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String SYSTEM_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String REQUEST_WINNING_NUMBER_BEFORE = "\n지난 주 당첨 번호를 입력해주세요.(ex 1, 2, 3, 4, 5, 6)";
    private static final String REQUEST_BONUS_BALL_NUMBER = "보너스 볼을 입력해주세요.";
    private static final String WINNING_STATS = "\n당첨 통계\n------------";

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_MESSAGE + exceptionMessage);
    }

    public static void printRequestLottoPrice() {
        System.out.println(REQUEST_LOTTO_PRICE);
    }

    public static void printLottoCount(int count) {
        System.out.println(count + SYSTEM_LOTTO_COUNT);
    }

    public static void printWinningNumberBefore() {
        System.out.println(REQUEST_WINNING_NUMBER_BEFORE);
    }

    public static void printBonusBallNumber() {
        System.out.println(REQUEST_BONUS_BALL_NUMBER);
    }

    public static void printLottoStatisticTitle() {
        System.out.println(WINNING_STATS);
    }

    public static void printLottoStatistic(PrizeGrade prizeGrade, int prizeGradeCount) {
        if (prizeGrade == PrizeGrade.NONE) {
            return ;
        }
        if (prizeGrade == PrizeGrade.SECOND) {
            System.out.println(
                (prizeGrade.getMatchCount() + 1) + "개 일치, 보너스 볼 일치(" + prizeGrade.getPrizeMoney()
                    + "원) - " + prizeGradeCount + " 개");

            return;
        }

        System.out.println(
            prizeGrade.getMatchCount() + "개 일치(" + prizeGrade.getPrizeMoney() + "원) - "
                + prizeGradeCount + " 개");
    }

    public static void printTotalReturn(Double earningRate) {
        String profitOrLoss = "손해";

        if (earningRate >= 1) {
            profitOrLoss = "이득";
        }

        System.out.println(
            "총 수익률은 " + earningRate + "입니다.(기준이 1이기 때문에 결과적으로 " + profitOrLoss + "이라는 의미임)");
    }

    public static void printLottoNumber(Lotto lotto) {
        for (int j = 0; j < lotto.getLotto().size(); j++) {
            System.out.print(lotto.getLotto().get(j) + " ");
        }
    }
}
