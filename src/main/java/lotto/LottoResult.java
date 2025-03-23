package lotto;

import java.util.Objects;

public class LottoResult {
    private final LottoTicket ticket;
    private final MatchCount matchCount;

    public LottoResult(LottoTicket ticket, MatchCount matchCount) {
        this.ticket = ticket;
        this.matchCount = matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(ticket, that.ticket) && Objects.equals(matchCount, that.matchCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket, matchCount);
    }
}
