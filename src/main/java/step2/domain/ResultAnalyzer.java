package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 분석 기능을 정의한 클래스
 */
public class ResultAnalyzer {

    private ResultAnalyzer() {
    }

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
     * 총 당첨금을 반환한다.
     *
     * @param winningNumbers
     * @param tickets
     * @return
     */
    private static final int getTotalPrizeMoney(final int[] winningNumbers, final int bonusNumber, final List<Ticket> tickets) {
        return tickets.stream()
                .mapToInt(ticket -> getPrizeMoney(winningNumbers, bonusNumber, ticket))
                .sum();
    }

    /**
     * 당첨금을 반환한다.
     *
     * @param winningNumber
     * @return
     */
    public static final int getPrizeMoney(final int[] winningNumber, final int bonusNumber, final Ticket ticket) {
        final long matchCount = ticket.matchCount(winningNumber);

        LottoRanking lottoRanking = Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking.getMatchCount() == matchCount)
                .findFirst()
                .orElse(null);

        if (lottoRanking == null)
            return 0;

        // 5개 번호 + 보너스 번호를 맞춘 경우 (2등)
        if (lottoRanking == LottoRanking.THIRD && ticket.matchCount(new int[]{bonusNumber}) == 1)
            return LottoRanking.SECOND.getPrizeMoney();


        return lottoRanking.getPrizeMoney();
    }

    /**
     * 수익률을 반환한다.
     *
     * @param winningNumbers
     * @param tickets
     * @param spending
     * @return
     */
    public static final double getRateReturn(final int[] winningNumbers, final int bonusNumber, final List<Ticket> tickets, final int spending) {
        return getTotalPrizeMoney(winningNumbers, bonusNumber, tickets) / (spending * 1.0);
    }
}
