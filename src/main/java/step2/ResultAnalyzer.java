package step2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 분석 기능을 정의한 클래스
 */
public class ResultAnalyzer {
    
    private ResultAnalyzer() {}

    /**
     * 당첨 된 로또 갯수를 반환한다.
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
     * @param winningNumbers
     * @param tickets
     * @param prizeMoney
     * @param hitCount
     * @return
     */
    public static final int getPrizeMoney(final int[] winningNumbers, final List<Ticket> tickets, final int prizeMoney, final int hitCount) {
        return prizeMoney * getHitListCount(winningNumbers, tickets, hitCount);
    }

    /**
     * 수익률을 반환한다.
     * @param winningNumbers
     * @param tickets
     * @param spending
     * @return
     */
    public static final double getRateReturn(final int[] winningNumbers, final List<Ticket> tickets, int spending) {
        int prizeMoney = 0;

        prizeMoney += getPrizeMoney(winningNumbers, tickets, LottoRanking.FIRST.getPrizeMoney(), LottoRanking.FIRST.getHitCount());
        prizeMoney += getPrizeMoney(winningNumbers, tickets, LottoRanking.SECOND.getPrizeMoney(), LottoRanking.SECOND.getHitCount());
        prizeMoney += getPrizeMoney(winningNumbers, tickets, LottoRanking.THIRD.getPrizeMoney(), LottoRanking.THIRD.getHitCount());
        prizeMoney += getPrizeMoney(winningNumbers, tickets, LottoRanking.FOURTH.getPrizeMoney(), LottoRanking.FOURTH.getHitCount());

        return Math.ceil((prizeMoney / spending * 100) / 100.0);
    }
}
