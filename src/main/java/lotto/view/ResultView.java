package lotto.view;

import lotto.domain.LotteryPrize;
import lotto.dto.LotteryTicketDto;
import lotto.dto.LotteryTicketListDto;

public class ResultView {

    private static final String NUMBER_SEPARATOR = ", ";
    private static final String LINE_BREAKER = "%n";
    private static final String LINE_MARK = "------------------------";

    public static void printLotteryTickets(LotteryTicketListDto lotteryTicketList) {
        System.out.printf(MessageConstant.PURCHASED_RESULT + LINE_BREAKER, lotteryTicketList.manualSize(),
                lotteryTicketList.autoSize());
        for (LotteryTicketDto lotteryTicket : lotteryTicketList.getList()) {
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

    public static void printFinalResult(LotteryTicketListDto lotteryTicketList) {
        System.out.println(MessageConstant.FINAL_STATISTIC_RESULT);
        System.out.println(LINE_MARK);
        printLotteryPrizeResult(lotteryTicketList, LotteryPrize.FIRST);
        printLotteryPrizeResult(lotteryTicketList, LotteryPrize.SECOND);
        printLotteryPrizeResult(lotteryTicketList, LotteryPrize.THIRD);
        printLotteryPrizeResult(lotteryTicketList, LotteryPrize.FOURTH);
        printLotteryPrizeResult(lotteryTicketList, LotteryPrize.FIFTH);
        System.out.printf(MessageConstant.PROFIT_MARGIN_RESULT + LINE_BREAKER, lotteryTicketList.getProfitMargin());
    }

    private static void printLotteryPrizeResult(LotteryTicketListDto lotteryTicketList, LotteryPrize lotteryPrize) {
        int lotteryPrizeCount = lotteryTicketList.getLotteryPrizeCount(lotteryPrize);
        String message = MessageConstant.MATCH_RESULT;
        if (lotteryPrize == LotteryPrize.SECOND) {
            message = MessageConstant.MATCH_RESULT_SECOND_PRIZE;
        }
        System.out.printf(message + LINE_BREAKER,
                lotteryPrize.getMatchingCount(), lotteryPrize.getReward(), lotteryPrizeCount);
    }


}
