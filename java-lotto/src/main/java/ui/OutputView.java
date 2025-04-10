package ui;

import domain.Lotto.LottoResult;
import domain.Lotto.LottoTicket;
import domain.Lotto.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "output: %d";

    public void printOutput(int output) {
        System.out.printf(OUTPUT_MESSAGE + System.lineSeparator(), output);
    }

    public void printLottoTickets(List<LottoTicket> tickets) {
        System.out.printf("you purchased %d piece" + System.lineSeparator(), tickets.size());
        tickets.forEach(System.out::println);
    }

    public void printResult(LottoResult result) {
        System.out.println("winning statistics---------" + System.lineSeparator());
        Map<Rank, Integer> rankCounts = result.getMatchCounts();


        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue; // NONE은 출력하지 않음
            System.out.printf("%d matches", rank.getCountOfMatch());
            if (rank == Rank.SECOND) {
                System.out.print(" + Bonus");
            }
            System.out.printf(" (%dwon) - %d piece" + System.lineSeparator(),
                    rank.getWinningMoney(),
                    rankCounts.getOrDefault(rank, 0));
        }
        System.out.printf("total rate of return : %.2f." + System.lineSeparator(), result.calculateProfitRate(14000));
    }

    public void printLottoPurchaseResult(int manualCount, int autoCount, List<LottoTicket> allTickets) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.%n", manualCount, autoCount);
        allTickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }
}

