package lottery.view;

import lottery.domain.*;

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
    /*
    public static void printLotteryStatistics(StatisticsBoard statisticsBoard) {
        LotteryRank[] lotteryRanks = LotteryRank.values();
        for (LotteryRank lotteryRank : lotteryRanks) {
            System.out.println(lotteryRank.getRequiredNumberCounts() + "개 일치 (" + lotteryRank.getPrizeMoney() + "원) - "
            + statisticsBoard.findTicketCountsByLotteryRank(lotteryRank) + "개");
        }
    }


     */
    public static void printRateOfReturn(RateOfReturn rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn.getRateOfReturn() + "입니다.");
        if (rateOfReturn.isSurplus()) {
            System.out.println("기준이 1이기 때문에 결과적으로 이득입니다.");
            return;
        }
        System.out.println("기준이 1이기 때문에 결과적으로 손해입니다.");
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
