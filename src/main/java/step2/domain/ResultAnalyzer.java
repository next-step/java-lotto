package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
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
     * @param bonusNumber
     * @param bonusMatch
     * @param tickets
     * @return
     */
    public static final int getMatchTicketCount(
            final List<Integer> winningNumbers,
            final int bonusNumber,
            final boolean bonusMatch,
            final List<Ticket> tickets) {
        Predicate<Ticket> predicate = ticket -> ticket.checkPrize(winningNumbers);

        if (bonusMatch)
            predicate = predicate.and(ticket -> ticket.checkBonusNumber(bonusNumber));

        return tickets.stream()
                .filter(predicate)
                .collect(Collectors.toList())
                .size();
    }

    /**
     * 총 당첨금을 반환한다.
     *
     * @param winningNumbers
     * @param bonusNumber
     * @param tickets
     * @return
     */
    private static final int getTotalPrizeMoney(final List<Integer> winningNumbers, final int bonusNumber, final List<Ticket> tickets) {
        return tickets.stream()
                .mapToInt(ticket -> getPrizeMoney(winningNumbers, bonusNumber, ticket))
                .sum();
    }

    /**
     * 당첨금을 반환한다.
     *
     * @param winningNumber
     * @param bonusNumber
     * @param ticket
     * @return
     */
    public static final int getPrizeMoney(final List<Integer> winningNumber, final int bonusNumber, final Ticket ticket) {
        return LottoRanking.valueOf(ticket.matchCount(winningNumber), ticket.matchCount(bonusNumber) > 0).getPrizeMoney();
    }

    /**
     * 수익률을 반환한다.
     *
     * @param winningNumbers
     * @param bonusNumber
     * @param tickets
     * @param spending
     * @return
     */
    public static final double getRateReturn(final List<Integer> winningNumbers, final int bonusNumber, final List<Ticket> tickets, final int spending) {
        return getTotalPrizeMoney(winningNumbers, bonusNumber, tickets) / (spending * 1.0);
    }

    /**
     *
     * @return
     */
    public static List<LottoRanking> getRankingReports() {
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking != LottoRanking.MISS)
                .collect(Collectors.toList());
    }
}
