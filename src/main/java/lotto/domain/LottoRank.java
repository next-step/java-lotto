package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public static final int BOUNS_OF_MATCH = 1;

    public final int countOfMatch;
    public final int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRank valueOf(LottoTicket lottoTicket, LottoWinners lottoWinners) {
        LottoRank rank = Arrays.asList(LottoRank.values())
                    .stream()
                    .filter(lottoRank -> lottoRank.countOfMatch == LottoNumbers.matchOf(lottoTicket, lottoWinners.winnerNumbers()))
                    .findAny()
                    .orElse(MISS);

        boolean isBonus = LottoNumbers.bonusOf(lottoTicket, lottoWinners.bonusNumber());

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
