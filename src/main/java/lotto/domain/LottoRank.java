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

    public static LottoRank valueOf(LottoTicket lottoTicket,
            LottoNumbers winnerNumber, LottoNumbers bonusNumber) {
        boolean isBonus = matchOf(lottoTicket, bonusNumber) == BOUNS_OF_MATCH ? true : false;
        LottoRank rank = Arrays.asList(LottoRank.values())
                    .stream()
                    .filter(lottoRank -> lottoRank.countOfMatch == matchOf(lottoTicket, winnerNumber))
                    .findAny()
                    .orElse(MISS);

        if (rank == LottoRank.SECOND && !isBonus) {
            rank = LottoRank.THIRD;
        }

        return rank;
    }

    private static int matchOf(LottoTicket lottoTicket, LottoNumbers winnerNumber) {
        return (int) lottoTicket.lottoNumber()
                    .stream()
                    .filter(number -> numberContains(number, winnerNumber))
                    .count();
    }

    private static boolean numberContains(int number, LottoNumbers winnerNumber) {
        return winnerNumber.readOnlyNumbers()
                .contains(number);
    }

    public int winnerCount(List<LottoTicket> lottoTickets,
            LottoNumbers winnerNumber, LottoNumbers bonusNumber) {
        return (int)lottoTickets.stream()
                    .filter(ticket -> valueOf(ticket, winnerNumber, bonusNumber) == this)
                    .count();
    }
}
