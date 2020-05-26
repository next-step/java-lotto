package lottery.view;

import lottery.domain.LotteryMachine;
import lottery.domain.LotteryTicketsGroup;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printLotteryTicketCounts(LotteryMachine lotteryMachine) {
        System.out.println(lotteryMachine.getLotteryTicketCounts() + ViewMessages.RESULT_LOTTERY_TICKET_COUNTS);
    }

    public static void printLotteryTicketsNumbers(LotteryTicketsGroup lotteryTicketsGroup) {
        List<List<Integer>> lotteryTicketsNumbers = lotteryTicketsGroup.getLotteryTicketsNumbers();
    }
}
