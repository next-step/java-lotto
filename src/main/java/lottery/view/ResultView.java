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
        lotteryTicketsNumbers.forEach(ResultView::printLotteryNumbers);
    }

    private static void printLotteryNumbers(List<Integer> lotteryNumbers) {
        System.out.println("[");
        StringBuilder stringBuilder = new StringBuilder();
        int size = lotteryNumbers.size();

        for (int i = 0; i < size; i++) {
            if (stringBuilder.length() > 0)
                stringBuilder.append(", ");
            stringBuilder.append(lotteryNumbers.get(i));
        }
        System.out.println(stringBuilder.toString());
        System.out.println("]");
    }
}
