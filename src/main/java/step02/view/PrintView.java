package step02.view;

import java.util.Comparator;

import step02.dto.EarningRateDto;
import step02.dto.LottoDto;
import step02.dto.LottoGradeDto;
import step02.dto.LottoListDto;
import step02.dto.LottoResultDto;

public class PrintView {

    private static final String INIT_PURCHASE_PRICE_PHRASE = "구입금액을 입력해주세요.";
    private static final String INIT_MANUAL_LOTTO_COUNT_PHRASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INIT_MANUAL_LOTTO_PHRASE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LOTTO_PURCHASE_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String INIT_LAST_WEEK_WINNING_NUMBERS_PHRASE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String RESULT_WINNING_MESSAGE = "당첨 통계";
    private static final String LOTTO_WINNING_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";

    private static final String LOTTO_BONUS_WINNING_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개\n";
    private static final String LOTTO_EARNING_RATE_RESULT_MESSAGE = "총 수익률은 %.2f입니다.\n";
    private static final String LOTTO_LOSS_EARNING_RATE_RESULT_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";

    private static final String INIT_BONUS_BALL_NUMBER_PHRASE = "보너스 볼을 입력해 주세요.";

    private PrintView() {
    }

    public static void printInitPurchasePricePhrase() {
        System.out.println(INIT_PURCHASE_PRICE_PHRASE);
    }

    public static void printInitManualLottoCount() {
        System.out.println();
        System.out.println(INIT_MANUAL_LOTTO_COUNT_PHRASE);
    }

    public static void printInitManualLotto() {
        System.out.println();
        System.out.println(INIT_MANUAL_LOTTO_PHRASE);
    }

    public static void printLottoPurchaseCountMessage(int manualCount, int autoCount) {
        System.out.println();
        System.out.printf(LOTTO_PURCHASE_COUNT_MESSAGE, manualCount, autoCount);
    }

    public static void printInitLastWeekWinningNumbers() {
        System.out.println(INIT_LAST_WEEK_WINNING_NUMBERS_PHRASE);
    }

    public static void printLottoNumbers(LottoListDto lottoDtos) {
        lottoDtos.getLotto().stream()
            .map(LottoDto::getLotto)
            .forEach(System.out::println);

        System.out.println();
    }

    public static void printInitBonusBallNumberPhrase() {
        System.out.println(INIT_BONUS_BALL_NUMBER_PHRASE);
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
        System.out.println();
        System.out.println(RESULT_WINNING_MESSAGE);
        System.out.println("---------");

        lottoResultDto.getLottoGradeDtos().stream()
            .filter(i -> i.getWinnings() > 0)
            .sorted(Comparator.comparingInt(LottoGradeDto::getWinnings))
            .forEach(PrintView::printLottoResultByGrade);

        printLottoEarningRateResult(lottoResultDto.getEarningRateDto());
    }

    private static void printLottoResultByGrade(LottoGradeDto lottoGradeDto) {
        String message = lottoGradeDto.isMustBonus() ? LOTTO_BONUS_WINNING_RESULT_MESSAGE : LOTTO_WINNING_RESULT_MESSAGE;
        System.out.printf(message, lottoGradeDto.getRightCount(), lottoGradeDto.getWinnings(), lottoGradeDto.getCount());
    }

    private static void printLottoEarningRateResult(EarningRateDto earningRateDto) {
        String message = earningRateDto.isEarn() ? LOTTO_EARNING_RATE_RESULT_MESSAGE : LOTTO_LOSS_EARNING_RATE_RESULT_MESSAGE;
        System.out.printf(message, earningRateDto.getValue());
    }
}

