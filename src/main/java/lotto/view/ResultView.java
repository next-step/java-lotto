package lotto.view;

import lotto.model.LotteryTickets;

public class ResultView {

    public static void purchaseCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printTickets(LotteryTickets lotteryTickets) {
        lotteryTickets.getTickets()
                .forEach((ticket) -> System.out.println(ticket.getNumbers().toString()));
    }
}
