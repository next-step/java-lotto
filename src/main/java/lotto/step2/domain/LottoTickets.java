package lotto.step2.domain;

import java.util.List;
import java.util.Objects;

public class LottoTickets {
    private final List<LottoTicket> issueLottoTickets;
    
    public LottoTickets(List<LottoTicket> issueLottoTickets) {
        this.issueLottoTickets = issueLottoTickets;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(issueLottoTickets, that.issueLottoTickets);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(issueLottoTickets);
    }
}
