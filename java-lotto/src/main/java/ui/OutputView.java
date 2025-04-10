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

    public void printResult(LottoResult result, int totalSpent) {
        System.out.println("winning statistics");
        System.out.println("---------");

        Map<Rank, Integer> rankCounts = result.getMatchCounts();

        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue; // 미당첨은 출력 생략

            System.out.printf("%d matches", rank.getCountOfMatch());
            if (rank == Rank.SECOND) {
                System.out.print(", bonus ball matches.");
            }
            System.out.printf(" (%d won) - %d matches" + System.lineSeparator(),
                    rank.getWinningMoney(),
                    rankCounts.getOrDefault(rank, 0));
        }

        double profitRate = result.calculateProfitRate(totalSpent);
        System.out.printf("total rate of return : %.2f" + System.lineSeparator(), profitRate);
        if (profitRate < 1.0) {
            System.out.println("(It means that it is a loss because the standard is 1.)");
        } else if (profitRate > 1.0) {
            System.out.println("(It means that it is profitable because the standard is 1.)");
        } else {
            System.out.println("(get one's money's worth)");
        }
    }

    public void printLottoPurchaseResult(int manualCount, int autoCount, List<LottoTicket> allTickets) {
        System.out.printf("You purchased %d copies manually and %d copies automatically." + System.lineSeparator(), manualCount, autoCount);
        allTickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }
}

