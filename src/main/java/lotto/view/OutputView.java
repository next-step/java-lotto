package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PrizeGrade;

public class OutputView {

    public static final String PRINT_ERROR_MESSAGE_FORMAT = "[ERROR] %s";
    private static final String PRINT_REQUEST_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_SYSTEM_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String PRINT_REQUEST_WINNING_NUMBER_BEFORE = "\n지난 주 당첨 번호를 입력해주세요.(ex 1, 2, 3, 4, 5, 6)";
    private static final String PRINT_REQUEST_BONUS_BALL_NUMBER = "보너스 볼을 입력해주세요.";
    private static final String PRINT_WINNING_STATS = "\n당첨 통계\n------------";
    private static final String PRINT_PRIZE_GRADE_RESULT_FORMAT = "%d개 일치%s(%d원) - %d개";
    private static final String PRINT_TOTAL_RETURN_FORMAT = "총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 %s이라는 의미임)";
    private static final String PRINT_LOTTO_NUMBER_FORMAT = "%d ";
    private static final String BONUS_RESULT = ", 보너스 볼 일치";

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(String.format(PRINT_ERROR_MESSAGE_FORMAT, exceptionMessage));
    }

    public static void printRequestLottoPrice() {
        System.out.println(PRINT_REQUEST_LOTTO_PRICE);
    }

    public static void printLottoCount(int count) {
        System.out.println(String.format(PRINT_SYSTEM_LOTTO_COUNT_FORMAT, count));
    }

    public static void printWinningNumberBefore() {
        System.out.println(PRINT_REQUEST_WINNING_NUMBER_BEFORE);
    }

    public static void printBonusBallNumber() {
        System.out.println(PRINT_REQUEST_BONUS_BALL_NUMBER);
    }

    public static void printLottoStatisticTitle() {
        System.out.println(PRINT_WINNING_STATS);
    }

    public static void printLottoStatistic(PrizeGrade prizeGrade, int prizeGradeCount) {
        if (prizeGrade == PrizeGrade.NONE) {
            return;
        }
        if (prizeGrade == PrizeGrade.SECOND) {
            System.out.println(
                String.format(
                    PRINT_PRIZE_GRADE_RESULT_FORMAT
                    , prizeGrade.getMatchCount() + 1
                    , BONUS_RESULT
                    , prizeGrade.getPrizeMoney()
                    , prizeGradeCount
                )
            );

            return;
        }

        System.out.println(
            String.format(
                PRINT_PRIZE_GRADE_RESULT_FORMAT
                , prizeGrade.getMatchCount()
                , ""
                , prizeGrade.getPrizeMoney()
                , prizeGradeCount
            )
        );
    }

    public static void printTotalReturn(Double earningRate) {
        String profitOrLoss = "손해";

        if (earningRate >= 1) {
            profitOrLoss = "이득";
        }

        System.out.println(
            String.format(
                PRINT_TOTAL_RETURN_FORMAT,
                earningRate,
                profitOrLoss
            )
        );
    }

    public static void printLottoNumber(Lotto lotto) {
        for (int j = 0; j < lotto.getLotto().size(); j++) {
            System.out.print(
                String.format(PRINT_LOTTO_NUMBER_FORMAT, lotto.getLotto().get(j).getLottoNumber())
            );
        }
    }
}
