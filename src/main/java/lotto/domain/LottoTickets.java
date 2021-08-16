package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets() {
        lottoTickets = new ArrayList<>();
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public void add(LottoTicket lottoTicket) {
        this.lottoTickets.add(lottoTicket);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }

    public LottoTickets mergeWith(LottoTickets other) {
        List<LottoTicket> mergedLottoTickets = new ArrayList<>(this.lottoTickets);
        mergedLottoTickets.addAll(other.lottoTickets);
        return new LottoTickets(mergedLottoTickets);
    }
}
