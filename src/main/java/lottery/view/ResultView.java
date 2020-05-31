package lottery.view;

import lottery.domain.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultView {

    private static final int COMMA_BOUNDARY_LENGTH = 1;

    private ResultView() {
    }

    public static void printLotteryGameInformation(PurchasePrice purchasePrice,
                                                   LotteryTicketsGroup lotteryTicketsGroup) {
        System.out.printf(ViewMessages.RESULT_LOTTERY_TICKET_COUNTS
                , purchasePrice.getPurchasableLotteryTicketCounts());
        List<List<Integer>> lotteryTicketsNumbers = lotteryTicketsGroup.getLotteryTicketsNumbers();
        lotteryTicketsNumbers.forEach(ResultView::printLotteryNumbers);

    }

    public static void printLotteryGameResult(LotteryGameResult lotteryGameResult) {
        System.out.println(ViewMessages.RESULT_HEADER);
        Arrays.stream(LotteryRank.values())
                .filter(lotteryRank -> lotteryRank != LotteryRank.MISS)
                .sorted(Comparator.comparing(LotteryRank::getPrizeMoney))
                .forEach(lotteryRank -> printEachRankResult(lotteryRank, lotteryGameResult));
    }

    public static void printRateOfReturn(RateOfReturn rateOfReturn) {
        System.out.printf(ViewMessages.RESULT_RATE_OF_RETURN, rateOfReturn.getRateOfReturn());
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
        System.out.printf(ViewMessages.RESULT_MATCH_NUMBER_COUNTS, lotteryRank.getMatchNumberCounts());
        if (lotteryRank == LotteryRank.SECOND_PRIZE) {
            System.out.printf(ViewMessages.RESULT_BONUS_BALL_SUFFIX);
        }
        System.out.printf(ViewMessages.RESULT_MONETARY_UNIT_COUNTS,
                lotteryRank.getPrizeMoney(),
                lotteryGameResult.findWinnerTicketCountsByRank(lotteryRank));
    }
}
