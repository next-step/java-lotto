package lottery.view;

import lottery.domain.*;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private static final int COMMA_BOUNDARY_LENGTH = 1;

    private ResultView() {
    }

    public static void printLotteryGameInformation(PurchasePrice purchasePrice,
                                                   LotteryTicketsGroup lotteryTicketsGroup) {
        System.out.println(purchasePrice.getPurchasableLotteryTicketCounts()
                + ViewMessages.RESULT_LOTTERY_TICKET_COUNTS);
        List<List<Integer>> lotteryTicketsNumbers = lotteryTicketsGroup.getLotteryTicketsNumbers();
        lotteryTicketsNumbers.forEach(ResultView::printLotteryNumbers);

    }

    public static void printLotteryGameResult(LotteryGameResult lotteryGameResult) {
        Arrays.stream(LotteryRank.values())
                .forEach(lotteryRank -> printEachRankResult(lotteryRank, lotteryGameResult));
    }

    public static void printRateOfReturn(RateOfReturn rateOfReturn) {
        System.out.print(ViewMessages.RESULT_REVENUE_TOTAL);
        System.out.print(rateOfReturn.getRateOfReturn());
        System.out.print(ViewMessages.RESULT_SENTENCE_SUFFIX);
        if (rateOfReturn.isSurplus()) {
            System.out.println(ViewMessages.RESULT_SURPLUS);
            return;
        }
        System.out.println(ViewMessages.RESULT_LOSS);
    }

    private static void printLotteryNumbers(List<Integer> lotteryNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ViewMessages.LEFT_BRACKET);
        lotteryNumbers.forEach(lotteryNumber -> appendLotteryNumber(lotteryNumber, stringBuilder));
        stringBuilder.append(ViewMessages.RIGHT_BRACKET);
        System.out.println(stringBuilder.toString());
    }

    private static void appendLotteryNumber(Integer lotteryNumber, StringBuilder stringBuilder) {
        if (stringBuilder.length() > COMMA_BOUNDARY_LENGTH)
            stringBuilder.append(ViewMessages.COMMA);
        stringBuilder.append(lotteryNumber);
    }

    private static void printEachRankResult(LotteryRank lotteryRank, LotteryGameResult lotteryGameResult) {
        System.out.print(lotteryRank.getMatchNumberCounts());
        System.out.print(ViewMessages.RESULT_MATCH);
        System.out.print(lotteryRank.getPrizeMoney());
        System.out.print(ViewMessages.RESULT_MONETARY_UNIT);
        System.out.print(lotteryGameResult.findWinnerTicketCountsByRank(lotteryRank));
        System.out.println(ViewMessages.RESULT_COUNT);
    }
}
