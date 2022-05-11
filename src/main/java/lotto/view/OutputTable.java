package lotto.view;

import lotto.model.LotteryResult;
import lotto.model.Lotto;

import java.util.List;

public final class OutputTable {

    private static final String BUY_THING_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구입했습니다.\n";
    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String UNDER_BAR = "_________";
    private static final String YIELD_MESSAGE = "총 수익률은 %.2f입니다. (기준이 %d이기 때문에 결과적으로 %s라는 의미임)";
    private static final String WIN_MESSAGE = "이득";
    private static final String LOSE_MESSAGE = "손해";

    private OutputTable() {
    }

    public static void buyThings(int manualProductCount, int autoProductCount) {
        System.out.printf(BUY_THING_MESSAGE, manualProductCount, autoProductCount);
    }

    public static void printProductInfos(List<Lotto> lotteryTickets) {
        for (Lotto lotto : lotteryTickets) {
            System.out.println(lotto.numbers());
        }
    }

    public static void resultStatistics(List<LotteryResult> lotteryResults) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(UNDER_BAR);
        for (LotteryResult lotteryResult : lotteryResults) {
            System.out.println(lotteryResult);
        }
    }


    public static void printYield(double yield, int isStandard) {
        System.out.printf(YIELD_MESSAGE, yield, isStandard, standardMessage(yield > isStandard));
    }

    private static String standardMessage(boolean isStandard) {
        if (isStandard) {
            return WIN_MESSAGE;
        }
        return LOSE_MESSAGE;
    }

}
