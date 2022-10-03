package step02.view;

import java.util.List;

import step02.domain.LottoGrade;

public class PrintView {

    private static final String INIT_PURCHASE_PRICE_PHRASE = "구입금액을 입력해주세요.";
    private static final String LOTTO_PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String INIT_LAST_WEEK_WINNING_NUMBERS_PHRASE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String RESULT_WINNING_MESSAGE = "당첨 통계";
    private static final String LOTTO_WINNING_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String LOTTO_EARNING_RATE_RESULT_MESSAGE = "총 수익률은 %.2f입니다.\n";

    private PrintView() {
    }

    public static void printBlank() {
        System.out.println();
    }

    public static void printInitPurchasePricePhrase() {
        System.out.println(INIT_PURCHASE_PRICE_PHRASE);
    }

    public static void printLottoPurchaseCountMessage(int count) {
        System.out.printf(LOTTO_PURCHASE_COUNT_MESSAGE, count);
    }

    public static void printInitLastWeekWinningNumbers() {
        System.out.println(INIT_LAST_WEEK_WINNING_NUMBERS_PHRASE);
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printResultWinningMessage() {
        System.out.println(RESULT_WINNING_MESSAGE);
        System.out.println("---------");
    }

    public static void printLottoResultByGrade(LottoGrade lottoGrade, int count) {
        System.out.printf(LOTTO_WINNING_RESULT_MESSAGE, lottoGrade.getRightCount(), lottoGrade.getWinnings(), count);
    }

    public static void printLottoEarningRateResult(float earningRate) {
        System.out.printf(LOTTO_EARNING_RATE_RESULT_MESSAGE, earningRate);
    }
}

