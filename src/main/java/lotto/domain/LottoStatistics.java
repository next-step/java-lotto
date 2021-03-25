package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoStatistics {
    private final LottoDiscriminator lottoDiscriminator;
    private final List<LottoTicket> lottoTickets;

    public LottoStatistics(final LottoDiscriminator lottoDiscriminator, final List<LottoTicket> lottoTickets) {
        this.lottoDiscriminator = lottoDiscriminator;
        this.lottoTickets = lottoTickets;
    }

    public int lottoTicketsCount(LottoRank lottoRank) {
        return (int) lottoTickets.stream()
                .filter(e -> lottoDiscriminator.lottoRank(e) == lottoRank)
                .count();
    }

    public double yield(int payment) {
        return (double) totalPrize() / payment;
    }

    private long totalPrize() {
        return lottoTicketsPrize(LottoRank.FIRST) + lottoTicketsPrize(LottoRank.SECOND) +
                lottoTicketsPrize(LottoRank.THIRD) + lottoTicketsPrize(LottoRank.FOURTH) +
                lottoTicketsPrize(LottoRank.FIFTH);
    }

    private long lottoTicketsPrize(LottoRank lottoRank) {
        return (long) lottoRank.winningPrize() * lottoTicketsCount(lottoRank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStatistics that = (LottoStatistics) o;
        return Objects.equals(lottoDiscriminator, that.lottoDiscriminator) && Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoDiscriminator, lottoTickets);
    }
}
