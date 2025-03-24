package lotto;

import java.util.Objects;

public class LottoResult {
    private final LottoTicket ticket;
    private final PrizeRank rank;

    public LottoResult(LottoTicket ticket, MatchCount matchCount) {
        this.ticket = ticket;
        this.rank = PrizeRank.of(matchCount);
    }

    public int getPrize() {
        return rank.getPrize();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(ticket, that.ticket) && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket, rank);
    }
}
