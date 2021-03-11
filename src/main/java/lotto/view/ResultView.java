package lotto.view;

import lotto.dto.LotteryPrizeResult;
import lotto.dto.LotteryStatisticMatchResult;
import lotto.dto.LotteryTicketDto;

import java.util.List;

public class ResultView {

    private static final String NUMBER_SEPARATOR = ", ";
    private static final String LINE_BREAKER = "%n";

    public static void printLotteryTickets(List<LotteryTicketDto> lotteryTickets) {
        System.out.printf(MessageConstant.PURCHASED_RESULT+LINE_BREAKER, lotteryTickets.size());
        for (LotteryTicketDto lotteryTicket : lotteryTickets) {
            System.out.printf(MessageConstant.LOTTERY_NUMBER_RESULT+LINE_BREAKER,extractLotteryNumbersToString(lotteryTicket));
        }
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static String extractLotteryNumbersToString(LotteryTicketDto lotteryTicketDto) {
        StringBuilder b = new StringBuilder();
        for (int number : lotteryTicketDto.getNumbers()) {
            b.append(number);
            b.append(NUMBER_SEPARATOR);
        }
        return b.toString().replaceAll(NUMBER_SEPARATOR+"$", "");
    }

    public static void printFinalResult(LotteryStatisticMatchResult lotteryStatisticMatchResult) {
        System.out.println(MessageConstant.FINAL_STATISTIC_RESULT);
        System.out.println("----------------------------------");
        printLotteryPrizeResult(lotteryStatisticMatchResult.getFirstPrizeLotteryResult());
        printLotteryPrizeResult(lotteryStatisticMatchResult.getSecondPrizeLotteryResult());
        printLotteryPrizeResult(lotteryStatisticMatchResult.getThirdPrizeLotteryResult());
        printLotteryPrizeResult(lotteryStatisticMatchResult.getFourthPrizeLotteryResult());
        System.out.printf(MessageConstant.PROFIT_MARGIN_RESULT+LINE_BREAKER,lotteryStatisticMatchResult.getProfitMargin() );
    }

    private static void printLotteryPrizeResult(LotteryPrizeResult lotteryPrizeResult) {
        System.out.printf(MessageConstant.MATCH_RESULT+LINE_BREAKER,lotteryPrizeResult.getMatchingCount(),lotteryPrizeResult.getReward(),lotteryPrizeResult.getMatchedLotteryTicketCount() );
    }


}
