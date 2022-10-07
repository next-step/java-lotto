package step02.view;

import java.util.Comparator;

import step02.dto.LottoDto;
import step02.dto.LottoGradeDto;
import step02.dto.LottoListDto;
import step02.dto.LottoResultDto;

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

    public static void printLottoNumbers(LottoListDto lottoDtos) {
        lottoDtos.getLotto().stream()
            .map(LottoDto::getLotto)
            .forEach(System.out::println);
    }

    public static void printInitBonusBallNumberPhrase() {
        System.out.println(INIT_BONUS_BALL_NUMBER_PHRASE);
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
        System.out.println(RESULT_WINNING_MESSAGE);
        System.out.println("---------");

        lottoResultDto.getLottoGradeDtos().stream()
            .filter(i -> i.getWinnings() > 0)
            .sorted(Comparator.comparingInt(LottoGradeDto::getWinnings))
            .forEach(PrintView::printLottoResultByGrade);

        printLottoEarningRateResult(lottoResultDto.getEarningRate());
    }

    private static void printLottoResultByGrade(LottoGradeDto lottoGradeDto) {
        String message = lottoGradeDto.isMustBonus() ? LOTTO_BONUS_WINNING_RESULT_MESSAGE : LOTTO_WINNING_RESULT_MESSAGE;
        System.out.printf(message, lottoGradeDto.getRightCount(), lottoGradeDto.getWinnings(), lottoGradeDto.getCount());
    }

    private static void printLottoEarningRateResult(float earningRate) {
        System.out.printf(LOTTO_EARNING_RATE_RESULT_MESSAGE, earningRate);
    }
}

