package lotto;

import java.util.Objects;

public class LottoWinner {
    private final LottoWinnerClass winnerClass;
    private final LottoTicket ticket;

    public LottoWinner(int matchingCount, LottoTicket ticket) {
        this.winnerClass = LottoWinnerClass.getByMatchingCount(matchingCount);
        this.ticket = ticket;
    }

    public LottoWinnerClass getWinnerClass() {
        return winnerClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinner that = (LottoWinner) o;
        return winnerClass == that.winnerClass && Objects.equals(ticket, that.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerClass, ticket);
    }
}
