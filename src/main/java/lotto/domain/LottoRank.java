package lotto.domain;

import java.util.List;

public enum LottoRank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private int rankCount;
    private int prize;
    private int winnerCount;

    LottoRank(int rankCount, int prize) {
        this.rankCount = rankCount;
        this.prize = prize;
    }

    public int rankCount() {
        return rankCount;
    }

    public int prize() {
        return prize;
    }

    public int winnerCount() {
        return winnerCount;
    }

    public LottoRank rank(LottoMachine lottoMachine, WinnerNumber winnerNumber) {
        List<LottoTicket> tickets = lottoMachine.lottoTickets();

        winnerCount = (int) tickets.stream()
                        .filter(ticket -> winnerNumberCount(ticket, winnerNumber))
                        .count();

        return this;
    }

    public boolean winnerNumberCount(LottoTicket ticket, WinnerNumber winnerNumber) {
        return ticket.lottoNumber()
                    .stream()
                    .filter(numbers -> numberContains(numbers, winnerNumber))
                    .count() == this.rankCount;
    }

    public boolean numberContains(int number, WinnerNumber winnerNumber) {
        return winnerNumber.readOnlyWinnerNumbers()
                    .contains(number);
    }

    public int rankPrizeSum() {
        return winnerCount * prize;
    }
}
