package lottery.view;

import lottery.domain.LotteryMachine;
import lottery.domain.LotteryRanks;
import lottery.domain.LotteryTicketsGroup;
import lottery.domain.StatisticsBoard;

import java.util.List;

public class ResultView {

    private static final int COMMA_BOUNDARY_LENGTH = 1;

    private ResultView() {
    }

    public static void printLotteryTicketCounts(LotteryMachine lotteryMachine) {
        System.out.println(lotteryMachine.getLotteryTicketCounts() + ViewMessages.RESULT_LOTTERY_TICKET_COUNTS);
    }

    public static void printLotteryTicketsNumbers(LotteryTicketsGroup lotteryTicketsGroup) {
        List<List<Integer>> lotteryTicketsNumbers = lotteryTicketsGroup.getLotteryTicketsNumbers();
        lotteryTicketsNumbers.forEach(ResultView::printLotteryNumbers);
    }

    public static void printLotteryStatistics(StatisticsBoard statisticsBoard) {
        LotteryRanks[] lotteryRanks = LotteryRanks.values();
        for (LotteryRanks lotteryRank : lotteryRanks) {
            System.out.println(lotteryRank.getRequiredNumberCounts() + "개 일치 (" + lotteryRank.getPrizeMoney() + "원) - "
            + statisticsBoard.findTicketCountsByLotteryRank(lotteryRank) + "개");
        }
    }

    private static void printLotteryNumbers(List<Integer> lotteryNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        int lotteryNumbersSize = lotteryNumbers.size();
        stringBuilder.append(ViewMessages.LEFT_BRACKET);
        for (int i = 0; i < lotteryNumbersSize; i++) {
            appendComma(stringBuilder);
            stringBuilder.append(lotteryNumbers.get(i));
        }
        stringBuilder.append(ViewMessages.RIGHT_BRACKET);
        System.out.println(stringBuilder.toString());
    }

    private static void appendComma(StringBuilder stringBuilder) {
        if (stringBuilder.length() > COMMA_BOUNDARY_LENGTH)
            stringBuilder.append(ViewMessages.COMMA);
    }
}
