package lotto.view;

import lotto.model.LotteryResult;
import lotto.model.Lotto;

import java.util.List;

public final class OutputTable {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_THING_MESSAGE = "%d개를 구입하였습니다.\n";
    private static final String LAST_WEEK_AWARD_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String UNDER_BAR = "_________";

    private static final String YIELD_MESSAGE = "총 수익률은 %.2f입니다. (기준이 %d이기 때문에 결과적으로 %s라는 의미임)";
    private static final String WIN_MESSAGE = "이득";
    private static final String LOSE_MESSAGE = "손해";

    private OutputTable() {
    }

    public static void inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public static void buyThings(Integer productCount) {
        System.out.printf(BUY_THING_MESSAGE, productCount);
    }

    public static void printProductInfos(List<Lotto> lotteryTickets) {
        for (Lotto lotto : lotteryTickets) {
            System.out.println(lotto.numbers());
        }
    }

    public static void lastWeekAwardNumber() {
        System.out.println();
        System.out.println(LAST_WEEK_AWARD_NUMBER_MESSAGE);
    }

    public static void resultStatisticsMessage() {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(UNDER_BAR);
    }

    public static void resultStatistics(List<LotteryResult> lotteryResults) {
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

    public static void getBonus() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
