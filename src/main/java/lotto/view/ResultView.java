package lotto.view;

import lotto.model.ticket.LotteryTickets;

import java.util.List;

public class ResultView {

    public static void printLotteryCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printTickets(LotteryTickets lotteryTickets) {
        lotteryTickets.getTickets()
                .forEach((ticket) -> System.out.println(ticket.print()));
    }

    public static void printResult(List<String> results) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        results.forEach(System.out::println);
    }
}
