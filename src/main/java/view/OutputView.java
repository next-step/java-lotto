package view;

import domain.*;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTERY_NUMBER_MESSAGE = "[%s]\n";
    private static final String RESULT_WINNING_MESSAGE = "당첨통계";
    private static final String WINNING_PRIZE_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String LOTTERY_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String PROFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 이익 이라는 의미임)";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String COMMA_AND_SPACING = ", ";
    private static final String NEXT_LINE = "\n";
    private static final String HYPHEN_LINE = "----------";
    private static final int LAST_COMMA_LENGTH = 2;
    private static final int RANK_NUMBER_MIN = 3;
    private static final int RANK_NUMBER_MAX = 6;

    public static void purchaseLottery(Store store) {
        System.out.printf(PURCHASE_MESSAGE, store.lotteryCount());
    }

    public static void printLotteryNumber(LotteryTickets lotteryTickets) {
        int loopNumber = lotteryTickets.size();
        for (int i = 0; i < loopNumber; i++) {
            System.out.printf(LOTTERY_NUMBER_MESSAGE, lotteryNumber(lotteryTickets.lotteryTicket(i)));
        }

        System.out.print(NEXT_LINE);
    }

    private static String lotteryNumber(LotteryTicket lotteryTicket) {
        String numbers = "";
        int loopNumber = lotteryTicket.size();
        for (int i = 0; i < loopNumber; i++) {
            numbers += lotteryTicket.getLotteryNumber(i) + COMMA_AND_SPACING;
        }

        return numbers.substring(0, numbers.length() - LAST_COMMA_LENGTH);
    }

    public static void resultWinningMessage() {
        System.out.print(NEXT_LINE);
        System.out.println(RESULT_WINNING_MESSAGE);
        System.out.println(HYPHEN_LINE);
    }

    public static void printWinningPrize(RankGroup rankGroup) {
        for (int i = RANK_NUMBER_MIN; i <= RANK_NUMBER_MAX; i++) {
            System.out.printf(WINNING_PRIZE_MESSAGE, i, rankGroup.moneyPrizeRank(i), rankGroup.count(i));
            System.out.printf(NEXT_LINE);
        }
    }

    public static void resultLotteryProfit(MoneyPrize moneyPrize, Store store) {
        double profit = moneyPrize.lotteryProfit(store.lotteryCount());
        System.out.printf(LOTTERY_PROFIT_MESSAGE + profitAndLossMessage(profit), profit);
        System.out.printf(NEXT_LINE);
    }

    private static String profitAndLossMessage(double profit) {
        if (profit < 1) {
            return LOSS_MESSAGE;
        }
        return PROFIT_MESSAGE;
    }
}
