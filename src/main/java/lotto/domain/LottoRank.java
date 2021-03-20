package lotto.domain;

import lotto.strategy.Numbers;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    ZERO(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    public final int matchCount;
    public final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank checkTicketRank(LottoTicket lottoTicket, Numbers winnerNumber) {
        return Arrays.asList(LottoRank.values())
                    .stream()
                    .filter(lottoRank -> lottoRank.matchCount == checkLottoRank(lottoTicket, winnerNumber))
                    .findAny()
                    .orElse(ZERO);
    }

    private static int checkLottoRank(LottoTicket lottoTicket, Numbers winnerNumber) {
        return (int) lottoTicket.lottoNumber()
                    .stream()
                    .filter(number -> numberContains(number, winnerNumber))
                    .count();
    }

    private static boolean numberContains(int number, Numbers winnerNumber) {
        return winnerNumber.readOnlyNumbers()
                .contains(number);
    }

    public int winnerCount(List<LottoTicket> lottoTickets, Numbers winnerNumber) {
        return (int)lottoTickets.stream()
                    .filter(ticket -> checkTicketRank(ticket, winnerNumber) == this)
                    .count();
    }
}
