package lotto.view;

import lotto.dto.LotteryStatisticMatchResult;
import lotto.dto.LotteryTicketDto;

import java.util.List;

public class ResultView {

    private static final String NUMBER_SEPARATOR = ",";

    public static void printLotteryTickets(List<LotteryTicketDto> lotteryTickets) {
        System.out.printf(MessageConstant.PURCHASED_RESULT, lotteryTickets.size());

    }

    private static String extractLotteryNumbersToString(LotteryTicketDto lotteryTicketDto) {
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int number : lotteryTicketDto.getNumbers()) {
            b.append(number);
            b.append(NUMBER_SEPARATOR);
        }
        b.append("]");
        return b.toString().replaceAll(NUMBER_SEPARATOR+"$", "");
    }

    public static void printFinalResult(LotteryStatisticMatchResult lotteryStatisticMatchResult) {

    }
}
