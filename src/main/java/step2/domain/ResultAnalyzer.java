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
     * @param hitCount
     * @return
     */
    public static final int getHitListCount(final int[] winningNumbers, final List<Ticket> tickets, final int hitCount) {
        return tickets.stream()
                .filter(ticket -> ticket.getHitCount(winningNumbers) == hitCount)
                .collect(Collectors.toList())
                .size();
    }

    /**
     * 당첨금을 반환한다.
     *
     * @param ranking
     * @param winningNumbers
     * @param tickets
     * @return
     */
    public static final int getPrizeMoney(final LottoRanking ranking, final int[] winningNumbers, final List<Ticket> tickets) {
        return ranking.getPrizeMoney(getHitListCount(winningNumbers, tickets, ranking.getHitCount()));
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
        int prizeMoney = 0;

        prizeMoney += getPrizeMoney(LottoRanking.FIRST, winningNumbers, tickets);
        prizeMoney += getPrizeMoney(LottoRanking.SECOND, winningNumbers, tickets);
        prizeMoney += getPrizeMoney(LottoRanking.THIRD, winningNumbers, tickets);
        prizeMoney += getPrizeMoney(LottoRanking.FOURTH, winningNumbers, tickets);

        return Math.ceil((prizeMoney / spending * 100) / 100.0);
    }
}
