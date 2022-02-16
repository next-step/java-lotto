package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PrizeGrade;

public class OutputView {

    public static final String PRINT_ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";
    private static final String PRINT_REQUEST_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_REQUEST_MANUAL_LOTTO_COUNT = "%n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PRINT_REQUEST_MANUAL_LOTTO_NUMBERS = "%n수동으로 구매할 번호를 입력해 주세요.";
    private static final String PRINT_SYSTEM_LOTTO_COUNT_FORMAT = "%n수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";
    private static final String PRINT_REQUEST_WINNING_NUMBER_BEFORE = "\n지난 주 당첨 번호를 입력해주세요.(ex 1, 2, 3, 4, 5, 6)";
    private static final String PRINT_REQUEST_BONUS_BALL_NUMBER = "보너스 볼을 입력해주세요.";
    private static final String PRINT_WINNING_STATS = "\n당첨 통계\n------------";
    private static final String PRINT_PRIZE_GRADE_RESULT_FORMAT = "%d개 일치%s(%d원) - %d개%n";
    private static final String PRINT_TOTAL_RETURN_FORMAT = "총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 %s이라는 의미임)%n";
    private static final String PRINT_LOTTO_NUMBER_FORMAT = "%d";
    private static final String BONUS_RESULT = ", 보너스 볼 일치";

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.printf(PRINT_ERROR_MESSAGE_FORMAT, exceptionMessage);
    }

    public static void printRequestLottoPrice() {
        System.out.println(PRINT_REQUEST_LOTTO_PRICE);
    }

    public static void printRequestManualLottoCount() {
        System.out.println(PRINT_REQUEST_MANUAL_LOTTO_COUNT);
    }

    public static void printRequestManualLottoNumbers() {
        System.out.println(PRINT_REQUEST_MANUAL_LOTTO_NUMBERS);
    }

    public static void printLottoCount(int manualCount, int autoCount) {
        System.out.printf(PRINT_SYSTEM_LOTTO_COUNT_FORMAT, manualCount, autoCount);
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
            System.out.printf(
                PRINT_PRIZE_GRADE_RESULT_FORMAT
                , prizeGrade.getMatchCount() + 1
                , BONUS_RESULT
                , prizeGrade.getPrizeMoney()
                , prizeGradeCount
            );

            return;
        }

        System.out.printf(
            PRINT_PRIZE_GRADE_RESULT_FORMAT
            , prizeGrade.getMatchCount()
            , ""
            , prizeGrade.getPrizeMoney()
            , prizeGradeCount
        );
    }

    public static void printTotalReturn(Double earningRate) {
        String profitOrLoss = "손해";

        if (earningRate >= 1) {
            profitOrLoss = "이득";
        }

        System.out.printf(
            PRINT_TOTAL_RETURN_FORMAT
            , earningRate
            , profitOrLoss
        );
    }

    public static void printLottoNumber(Lotto lotto) {
        final int lottoSize = lotto.getLotto().size();

        System.out.print("[");
        for (int j = 0; j < lottoSize - 1; j++) {
            System.out.printf(
                PRINT_LOTTO_NUMBER_FORMAT + ", ",
                lotto.getLotto().get(j).getLottoNumber()
            );
        }
        System.out.printf(
            PRINT_LOTTO_NUMBER_FORMAT,
            lotto.getLotto().get(lottoSize - 1).getLottoNumber()
        );
        System.out.print("]");
    }
}
