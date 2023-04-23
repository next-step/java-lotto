package lotto;

import java.util.List;

public class OutputView {
    public static void printLotteryTickets(List<List<Integer>> lotteryTickets) {
        System.out.println(lotteryTickets.size() + "개를 구매했습니다.");
        for (List<Integer> lotteryTicket : lotteryTickets) {
            System.out.println(lotteryTicket);
        }
    }
}
