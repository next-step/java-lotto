package study.step4.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000, (countOfMatch, matchBonus) -> countOfMatch == 6),
    SECOND(5, 30_000_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && matchBonus),
    THIRD(5, 1_500_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && !matchBonus),
    FOURTH(4, 50_000, (countOfMatch, matchBonus) -> countOfMatch == 4),
    FIFTH(3, 5_000, (countOfMatch, matchBonus) -> countOfMatch == 3),
    MISS(0, 0, (countOfMatch, matchBonus) -> countOfMatch < 3);

    public final int countOfMatch;
    public final int winningMoney;
    private final LottoRankPolicy policy;

    LottoRank(int countOfMatch, int winningMoney, LottoRankPolicy policy) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.policy = policy;
    }

    public static LottoRank valueOf(LottoTicket lottoTicket, LottoWinners lottoWinners) {
        return Stream.of(LottoRank.values())
                .filter(rank -> rank.policy.test(lottoWinners.matchOf(lottoTicket), lottoWinners.bonusOf(lottoTicket)))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int winnerCount(List<LottoTicket> lottoTickets, LottoWinners lottoWinners) {
        return (int)lottoTickets.stream()
                .filter(ticket -> valueOf(ticket, lottoWinners) == this)
                .count();
    }
}
