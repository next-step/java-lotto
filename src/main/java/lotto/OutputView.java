package lotto;

import java.util.List;

public class OutputView {
    public static void printLotteryTickets(LottoTickets lotteryTickets) {
        System.out.println(lotteryTickets.size() + "개를 구매했습니다.");
        for (LottoTicket lotteryTicket : lotteryTickets.getTickets()) {
            System.out.println(lotteryTicket.getNumbers());
        }
    }
}
