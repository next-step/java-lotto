package lotto.view;

import lotto.domain.LotteryPrize;
import lotto.dto.LotteryPrizeResult;
import lotto.dto.LotteryStatisticMatchResult;
import lotto.dto.LotteryTicketDto;

import java.util.List;

public class ResultView {

    private static final String NUMBER_SEPARATOR = ", ";
    private static final String LINE_BREAKER = "%n";
    private static final String LINE_MARK = "------------------------";

    public static void printLotteryTickets(List<LotteryTicketDto> lotteryTickets) {
        System.out.printf(MessageConstant.PURCHASED_RESULT + LINE_BREAKER, lotteryTickets.size());
        for (LotteryTicketDto lotteryTicket : lotteryTickets) {
            System.out.printf(MessageConstant.LOTTERY_NUMBER_RESULT + LINE_BREAKER,
                    extractLotteryNumbersToString(lotteryTicket));
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
        return b.toString().replaceAll(NUMBER_SEPARATOR + "$", "");
    }

    public static void printFinalResult(LotteryStatisticMatchResult lotteryStatisticMatchResult) {
        System.out.println(MessageConstant.FINAL_STATISTIC_RESULT);
        System.out.println(LINE_MARK);
        printLotteryPrizeResult(lotteryStatisticMatchResult,LotteryPrize.FIRST);
        printLotteryPrizeResult(lotteryStatisticMatchResult,LotteryPrize.SECOND);
        printLotteryPrizeResult(lotteryStatisticMatchResult,LotteryPrize.THIRD);
        printLotteryPrizeResult(lotteryStatisticMatchResult,LotteryPrize.FOURTH);
        printLotteryPrizeResult(lotteryStatisticMatchResult,LotteryPrize.FIFTH);
        System.out.printf(MessageConstant.PROFIT_MARGIN_RESULT + LINE_BREAKER, lotteryStatisticMatchResult.getProfitMargin());
    }

    private static void printLotteryPrizeResult(LotteryStatisticMatchResult lotteryStatisticMatchResult,LotteryPrize lotteryPrize) {
        int lotteryPrizeCount = lotteryStatisticMatchResult.getLotteryPrizeCount(lotteryPrize);
        String message = MessageConstant.MATCH_RESULT;
        if(lotteryPrize == LotteryPrize.SECOND) {
            message = MessageConstant.MATCH_RESULT_SECOND_PRIZE;
        }
        System.out.printf(message + LINE_BREAKER,
                lotteryPrize.getMatchingCount(), lotteryPrize.getReward(), lotteryPrizeCount);
    }


}
