package lotto.view;

import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String LOTTO_TICKET_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 %.2f입니다.";

    public void printLottoTicketAmount(int amount) {
        System.out.printf(LOTTO_TICKET_AMOUNT_MESSAGE + "%n", amount);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers.toString());
    }

    public void printReturnRate(double returnRate) {
        System.out.printf(RETURN_RATE_MESSAGE + "%n", returnRate);
    }

    public void printMatchResult(Map<Rank, Integer> result) {
        System.out.println("\n당첨 통계\n---------");
        Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() >= 3)
                .forEach(rank -> {
                    int count = result.getOrDefault(rank, 0);
                    System.out.printf("%s (%d원) - %d개%n", rank.getDescription(), rank.getPrize(), count);
                });
    }
}
