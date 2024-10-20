package lotto.view;

import lotto.domain.Lotteries;
import lotto.domain.Lottery;
import lotto.domain.LottoStatistics;

public class ResultView {
    private static final String RESULT_TITLE = "당첨 통계";
    private static final String PURCHASED_LOTTO_NUMBER_LIST_POSTFIX = "개를 구매했습니다.";

    public static void printPurchasedLottoNumberList(Lotteries purchasedLotteries) {
        System.out.println(purchasedLotteries.size() + PURCHASED_LOTTO_NUMBER_LIST_POSTFIX);
        for (Lottery lottery : purchasedLotteries.getLotteries()) {
            System.out.println(lottery.toString());
        }
        System.out.println();
    }

    public static void printResult(LottoStatistics lottoStatistics, float profitRate) {
        System.out.println(RESULT_TITLE);
        System.out.println("---------");
        printLottoStatistics(lottoStatistics);
        printProfitRate(profitRate);
    }

    private static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println(lottoStatistics.toString());
    }

    private static void printProfitRate(float profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.%n", profitRate);
    }
}
