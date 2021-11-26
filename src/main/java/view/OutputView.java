package view;

import domain.*;

import java.util.stream.IntStream;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTERY_NUMBER_MESSAGE = "[%s]\n";
    private static final String RESULT_WINNING_MESSAGE = "당첨통계";
    private static final String WINNING_PRIZE_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String LOTTERY_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String PROFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 이익 이라는 의미임)";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String BONUS_BALL_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String COMMA_AND_SPACING = ", ";
    private static final String NEXT_LINE = "\n";
    private static final String HYPHEN_LINE = "----------";
    private static final int LAST_COMMA_LENGTH = 2;
    private static final int LOTTERY_START_NUMBER = 3;
    private static final int LOTTERY_END_NUMBER = 7;
    private static final int WINNING_FIVE = 5;
    private static final int BONUS_NONE = 0;
    private static final int BONUS = 1;
    private static final int PROFIT_STANDARD = 1;

    public static void purchaseLottery(Store store) {
        System.out.printf(PURCHASE_MESSAGE, store.lotteryCount());
    }

    public static void printLotteryNumber(LotteryTickets lotteryTickets) {
        int loopNumber = lotteryTickets.size();
        IntStream.range(0, loopNumber)
                .forEach(index -> {
                    int size = lotteryTickets.lotteryTicket(index).size();
                    String lotteryNumber = "";
                    for (int i = 0; i < size; i++) {
                        lotteryNumber += lotteryTickets.lotteryTicket(index).value(i) + COMMA_AND_SPACING;
                    }
                    lotteryNumber = lotteryNumber.substring(0, lotteryNumber.length() - LAST_COMMA_LENGTH);

                    System.out.printf(LOTTERY_NUMBER_MESSAGE, lotteryNumber);
                });
        System.out.print(NEXT_LINE);
    }

    public static void resultWinningMessage() {
        System.out.print(NEXT_LINE);
        System.out.println(RESULT_WINNING_MESSAGE);
        System.out.println(HYPHEN_LINE);
    }

    public static void printWinningPrize(RankGroup rankGroup) {
        IntStream.range(LOTTERY_START_NUMBER, LOTTERY_END_NUMBER)
                .forEach(rank -> {
                    System.out.printf(WINNING_PRIZE_MESSAGE, rank, rankGroup.moneyPrizeRank(rank, BONUS_NONE), rankGroup.count(rank, BONUS_NONE));
                    System.out.print(NEXT_LINE);
                    if (rank == WINNING_FIVE) {
                        System.out.printf(BONUS_BALL_MESSAGE, rank, rankGroup.moneyPrizeRank(rank, BONUS), rankGroup.count(rank, BONUS));
                        System.out.print(NEXT_LINE);
                    }
                });
    }

    public static void resultLotteryProfit(MoneyPrize moneyPrize, Store store) {
        double profit = moneyPrize.lotteryProfit(store.lotteryCount());
        System.out.printf(LOTTERY_PROFIT_MESSAGE + profitAndLossMessage(profit), profit);
        System.out.print(NEXT_LINE);
    }

    private static String profitAndLossMessage(double profit) {
        if (profit < PROFIT_STANDARD) {
            return LOSS_MESSAGE;
        }
        return PROFIT_MESSAGE;
    }
}
