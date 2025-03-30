package ui;

import lotto.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.YieldCalculator.calculateYield;

public class OutputView {

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    public static void printResult(List<Integer> winningNumbers, List<LottoTicket> lottoTickets) {
        var result = lottoTickets.stream()
                        .collect(Collectors.groupingBy(lottoTicket -> lottoTicket.countMatches(winningNumbers), Collectors.counting()));

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + result.getOrDefault(3L, 0L) + "개");
        System.out.println("4개 일치 (50000원) - " + result.getOrDefault(4L, 0L) + "개");
        System.out.println("5개 일치 (500000원) - " + result.getOrDefault(5L, 0L) + "개");
        System.out.println("6개 일치 (2000000000) - " + result.getOrDefault(6L, 0L) + "개");
        System.out.println("총 수익률은 " + calculateYield(result) + "%입니다.");
    }
}
