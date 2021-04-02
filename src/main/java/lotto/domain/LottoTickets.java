package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoRank> lottoRanks(LottoDiscriminator lottoDiscriminator) {
        return lottoTickets.stream()
                .map(lottoDiscriminator::lottoRank)
                .collect(Collectors.toList());
    }

    public int count() {
        return lottoTickets.size();
    }

    public LottoTickets combine(LottoTickets that) {
        return new LottoTickets(
                Stream.concat(lottoTickets.stream(), that.lottoTickets.stream())
                        .collect(Collectors.toList())
        );
    }

    public List<LottoTicket> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
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
}
