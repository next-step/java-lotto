package study.step2.domain;

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

    public static LottoRank findLottoRank(LottoTicket lottoTicket, LottoWinningNumber winnerNumber) {
        return Arrays.asList(LottoRank.values())
                    .stream()
                    .filter(lottoRank -> lottoRank.matchCount == checkLottoRank(lottoTicket, winnerNumber))
                    .findAny()
                    .orElse(ZERO);
    }

    private static int checkLottoRank(LottoTicket lottoTicket, LottoWinningNumber winnerNumber) {
        return (int) lottoTicket.getTicket()
                    .stream()
                    .filter(number -> isNumberContains(number, winnerNumber))
                    .count();
    }

    private static boolean isNumberContains(int number, LottoWinningNumber winnerNumber) {
        return winnerNumber.getLottoWinningNumber().contains(number);
    }

    public int winnerCount(List<LottoTicket> lottoTickets, LottoWinningNumber winnerNumber) {
        return (int)lottoTickets.stream()
                    .filter(ticket -> ticket.rank(winnerNumber) == this)
                    .count();
    }
}
