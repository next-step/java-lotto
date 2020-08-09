package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 분석 기능을 정의한 클래스
 */
public class ResultAnalyzer {

    private ResultAnalyzer() {}

    /**
     * 당첨 된 로또 갯수를 반환한다.
     *
     * @param winningNumbers
     * @param tickets
     * @param matchCount
     * @return
     */
    public static final int getMatchTicketCount(final int[] winningNumbers, final List<Ticket> tickets, final int matchCount) {
        return tickets.stream()
                .filter(ticket -> ticket.matchCount(winningNumbers) == matchCount)
                .collect(Collectors.toList())
                .size();
    }

    /**
     * 당첨금을 반환한다.
     *
     * @param winningNumbers
     * @param tickets
     * @return
     */
    private static final int getTotalPrizeMoney(final int[] winningNumbers, final List<Ticket> tickets) {
        return tickets.stream()
                .mapToInt(ticket -> ticket.prizeMoney(winningNumbers))
                .sum();
    }

    /**
     * 수익률을 반환한다.
     *
     * @param winningNumbers
     * @param tickets
     * @param spending
     * @return
     */
    public static final double getRateReturn(final int[] winningNumbers, final List<Ticket> tickets, int spending) {
        return Math.ceil((getTotalPrizeMoney(winningNumbers, tickets) / spending * 100) / 100.0);
    }
}
