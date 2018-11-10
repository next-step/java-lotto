package lotto;

import java.util.List;

public class ResultView {
    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printTicketNums(List<Ticket> tickets) {
        System.out.println(tickets.toString());
    }

    public static void printResult(Statistics statistics, Integer buyAmount) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)" + statistics.getMatchGroupNum(3) + "개");
        System.out.println("4개 일치 (50000원)" + statistics.getMatchGroupNum(4) + "개");
        System.out.println("5개 일치 (1500000원)" + statistics.getMatchGroupNum(5) + "개");
        System.out.println("6개 일치 (2000000000)" + statistics.getMatchGroupNum(6) + "개");

        System.out.println("총 수익률은 " + statistics.getProfitRate(buyAmount) + "입니다.");
    }
}
