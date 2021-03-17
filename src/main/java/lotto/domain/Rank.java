package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private int rankCount;
    private int prize;

    Rank(int rankCount, int prize) {
        this.rankCount = rankCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int rankCount(LottoMachine lottoMachine, WinnerNumber winnerNumber) {
        List<LottoTicket> tickets = lottoMachine.getLottoTickets();

        Long result = tickets.stream()
                        .filter(t -> winnerNumberCount(t, winnerNumber))
                        .count();

        return result.intValue();
    }

    public boolean winnerNumberCount(LottoTicket ticket, WinnerNumber winnerNumber) {
        return ticket.getLottoNumber()
                    .stream()
                    .filter(n -> numberContains(n, winnerNumber))
                    .count() == this.rankCount;
    }

    public boolean numberContains(int number, WinnerNumber winnerNumber) {
        return winnerNumber.getReadOnlyWinnerNumbers()
                    .contains(number);
    }
}
