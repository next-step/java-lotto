package lotto.domain;

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

    public static LottoRank checkTicketRank(LottoTicket lottoTicket, LottoNumbers winnerNumber) {
        return Arrays.asList(LottoRank.values())
                    .stream()
                    .filter(lottoRank -> lottoRank.matchCount == checkLottoRank(lottoTicket, winnerNumber))
                    .findAny()
                    .orElse(ZERO);
    }

    private static int checkLottoRank(LottoTicket lottoTicket, LottoNumbers winnerNumber) {
        return (int) lottoTicket.lottoNumber()
                    .stream()
                    .filter(number -> numberContains(number, winnerNumber))
                    .count();
    }

    private static boolean numberContains(int number, LottoNumbers winnerNumber) {
        return winnerNumber.readOnlyNumbers()
                .contains(number);
    }

    public int winnerCount(List<LottoTicket> lottoTickets, LottoNumbers winnerNumber) {
        return (int)lottoTickets.stream()
                    .filter(ticket -> checkTicketRank(ticket, winnerNumber) == this)
                    .count();
    }
}
