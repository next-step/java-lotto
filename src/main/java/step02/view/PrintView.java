package step02.view;

import java.util.List;
import java.util.Map;

import step02.domain.LottoGrade;
import step02.domain.LottoNumber;
import step02.domain.LottoResult;

public class PrintView {

    private static final String INIT_PURCHASE_PRICE_PHRASE = "구입금액을 입력해주세요.";
    private static final String LOTTO_PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String INIT_LAST_WEEK_WINNING_NUMBERS_PHRASE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String RESULT_WINNING_MESSAGE = "당첨 통계";
    private static final String LOTTO_WINNING_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";

    private static final String LOTTO_BONUS_WINNING_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개\n";
    private static final String LOTTO_EARNING_RATE_RESULT_MESSAGE = "총 수익률은 %.2f입니다.\n";

    private static final String INIT_BONUS_BALL_NUMBER_PHRASE = "보너스 볼을 입력해 주세요.";

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

    public static void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printInitBonusBallNumberPhrase() {
        System.out.println(INIT_BONUS_BALL_NUMBER_PHRASE);
    }

    public static void printLottoResult(LottoResult lottoResult, int purchasePrice) {
        Map<LottoGrade, Integer> lottoGradeResultMap = lottoResult.getLottoGradeResultMap();

        System.out.println(RESULT_WINNING_MESSAGE);
        System.out.println("---------");
        printLottoResultByGrade(LottoGrade.FIFTH, lottoGradeResultMap.getOrDefault(LottoGrade.FIFTH, 0));
        printLottoResultByGrade(LottoGrade.FOURTH, lottoGradeResultMap.getOrDefault(LottoGrade.FOURTH, 0));
        printLottoResultByGrade(LottoGrade.THIRD, lottoGradeResultMap.getOrDefault(LottoGrade.THIRD, 0));
        printLottoBonusResultByGrade(LottoGrade.SECOND, lottoGradeResultMap.getOrDefault(LottoGrade.SECOND, 0));
        printLottoResultByGrade(LottoGrade.FIRST, lottoGradeResultMap.getOrDefault(LottoGrade.FIRST, 0));

        float earningRate = lottoResult.getTotalAmount() / (float) purchasePrice;
        printLottoEarningRateResult(earningRate);
    }

    private static void printLottoResultByGrade(LottoGrade lottoGrade, int count) {
        System.out.printf(LOTTO_WINNING_RESULT_MESSAGE, lottoGrade.getRightCount(), lottoGrade.getWinnings(), count);
    }

    private static void printLottoBonusResultByGrade(LottoGrade lottoGrade, int count) {
        System.out.printf(LOTTO_BONUS_WINNING_RESULT_MESSAGE, lottoGrade.getRightCount(), lottoGrade.getWinnings(), count);
    }

    private static void printLottoEarningRateResult(float earningRate) {
        System.out.printf(LOTTO_EARNING_RATE_RESULT_MESSAGE, earningRate);
    }
}

