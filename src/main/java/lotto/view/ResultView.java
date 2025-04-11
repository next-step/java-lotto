package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Map;

public class ResultView {
    private static final String LOTTO_TICKET_AMOUNT_MESSAGE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 %.2f입니다.";

    private ResultView() {
    }

    public static void printLottoTicketAmount(int manualAmount, int autoAmount) {
        System.out.println();
        System.out.printf(LOTTO_TICKET_AMOUNT_MESSAGE + "%n", manualAmount, autoAmount);
    }

    public static void printLottoNumbers(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getNumbers());
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf(RETURN_RATE_MESSAGE + "%n", returnRate);
    }

    public static void printMatchResult(Map<Rank, Integer> result) {
        System.out.println("\n당첨 통계\n---------");
        Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() >= 3)
                .forEach(rank -> {
                    int count = result.getOrDefault(rank, 0);
                    System.out.printf("%s (%d원) - %d개%n", rank.getDescription(), rank.getPrize(), count);
                });
    }
}
