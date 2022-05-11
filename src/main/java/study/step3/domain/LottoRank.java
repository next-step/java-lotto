package study.step3.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public final int countOfMatch;
    public final int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRank valueOf(LottoTicket lottoTicket, LottoWinners lottoWinners) {
        LottoRank rank = Arrays.asList(LottoRank.values())
                .stream()
                .filter(lottoRank -> lottoWinners.matchOf(lottoTicket, lottoRank.countOfMatch))
                .findAny()
                .orElse(MISS);

        boolean isBonus = lottoWinners.bonusOf(lottoTicket);
        if (rank == LottoRank.SECOND && !isBonus) {
            rank = LottoRank.THIRD;
        }
        return rank;
    }

    public int winnerCount(List<LottoTicket> lottoTickets, LottoWinners lottoWinners) {
        return (int)lottoTickets.stream()
                .filter(ticket -> valueOf(ticket, lottoWinners) == this)
                .count();
    }
}
