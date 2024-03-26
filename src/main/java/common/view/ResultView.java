package common.view;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoTicket;

public class ResultView {
    public static void showTicketCount(int count) {
        System.out.println(String.format("%s개를 구매했습니다.",count));
    }

    public static void showTicketNumber(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printResult(Map<Integer, Integer> winningResult, double rateOfReturn) {
        System.out.println("\n당첨 통계\n---------");
        System.out.println("3개 일치 (5000원)- " + winningResult.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (50000원)- " + winningResult.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1500000원)- " + winningResult.getOrDefault(5, 0) + "개");
        System.out.println("6개 일치 (2000000000원)- " + winningResult.getOrDefault(6, 0) + "개");
        System.out.printf("총 수익률은 %.2f입니다.%n", rateOfReturn);
    }
}
