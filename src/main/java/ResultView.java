import lotto.Lotto;
import lotto.LottoAmount;
import lotto.LottoResults;

import java.util.List;

public class ResultView {
    private static final String AVERAGE_TEXT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String PURCHASE_RESULT_TEXT_FORMAT = "%d개를 구매했습니다.";
    private static final String TOTAL_INCOME_RATE_TEXT_FORMAT = "총 수익률은 %.2f입니다.";

    private ResultView() {

    }

    public static void printLottoCounts(int rottoCounts) {
        String purchaseResultText = String.format(PURCHASE_RESULT_TEXT_FORMAT, rottoCounts);
        System.out.println(purchaseResultText);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printLottoResults(LottoResults lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        printAverageTexts(lottoResults);
        printIncomeRate(lottoResults);
    }

    private static void printAverageTexts(LottoResults lottoResults) {
        for (int count = 3; count < 7; count++) {
            int lottoAmount = LottoAmount
                    .getByFitCount(count)
                    .getAmount();

            int lotteryCount = lottoResults.countLotteryOf(count);
            String averageText = String.format(AVERAGE_TEXT_FORMAT, count, lottoAmount, lotteryCount);
            System.out.println(averageText);
        }
    }

    private static void printIncomeRate(LottoResults lottoResults) {
        double incomeRate = lottoResults.getIncomeRate();
        System.out.printf(TOTAL_INCOME_RATE_TEXT_FORMAT, incomeRate);
    }
}
