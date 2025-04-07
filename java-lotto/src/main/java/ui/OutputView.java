package ui;

import domain.Lotto.LottoResult;
import domain.Lotto.LottoTicket;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "output: %d";

    public void printOutput(int output) {
        System.out.printf(OUTPUT_MESSAGE + "%n", output);
    }

    public void printLottoTickets(List<LottoTicket> tickets) {
        System.out.printf("you purchased %d piece.%n", tickets.size());
        tickets.forEach(System.out::println);
    }

    public void printResult(LottoResult result) {
        System.out.println("winning statistics\n---------");
        result.getMatchCounts().forEach((match, count) -> {
            if (match >= 3) {
                System.out.printf("%d piece matches (%dwon)- %d piece%n", match, LottoResult.PRIZE_MONEY.get(match), count);
            }
        });
        System.out.printf("total rate of return : %.2f.%n", result.calculateProfitRate(14000));
    }

}

