package lottery.view;

import lottery.domain.*;

import java.util.Arrays;
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
        Arrays.stream(LotteryRank.values())
                .forEach(lotteryRank -> printEachRankResult(lotteryRank, statisticsBoard));
    }

    public static void printRateOfReturn(RateOfReturn rateOfReturn) {
        System.out.print(ViewMessages.RESULT_REVENUE_TOTAL);
        System.out.print(rateOfReturn.getRateOfReturn());
        System.out.print(ViewMessages.RESULT_SENTENCE_SUFFIX);
        if (rateOfReturn.isSurplus() == null) {
            System.out.println(ViewMessages.RESULT_EQUALITY);
            return;
        }
        if (rateOfReturn.isSurplus()) {
            System.out.println(ViewMessages.RESULT_SURPLUS);
            return;
        }
        System.out.println(ViewMessages.RESULT_LOSS);
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

    private static void printEachRankResult(LotteryRank lotteryRank, StatisticsBoard statisticsBoard) {
        System.out.print(lotteryRank.getMatchNumberCounts());
        System.out.print(ViewMessages.RESULT_MATCH);
        System.out.print(lotteryRank.getPrizeMoney());
        System.out.print(ViewMessages.RESULT_MONETARY_UNIT);
        System.out.print(statisticsBoard.findTicketCountsByLotteryRank(lotteryRank));
        System.out.println(ViewMessages.RESULT_COUNT);
    }
}
