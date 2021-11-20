package lotto.view;

import lotto.model.LotteryTickets;

import java.util.List;

public class ResultView {

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printTickets(LotteryTickets lotteryTickets) {
        lotteryTickets.getTickets()
                .forEach((ticket) -> System.out.println(ticket.print()));
    }

    public static void printResult(List<String> results) {
        results.forEach(System.out::println);
    }
}
