package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoStatistics {
    public static final long THREE_MATCHING_PRIZE = 5000L;
    public static final long FOUR_MATCHING_PRIZE = 50000L;
    public static final long FIVE_MATCHING_PRIZE = 1500000L;
    public static final long SIX_MATCHING_PRIZE = 2000000000L;

    private final LottoDiscriminator lottoDiscriminator;
    private final List<LottoTicket> lottoTickets;

    public LottoStatistics(final LottoDiscriminator lottoDiscriminator, final List<LottoTicket> lottoTickets) {
        this.lottoDiscriminator = lottoDiscriminator;
        this.lottoTickets = lottoTickets;
    }

    private int matchingLottoTicketsCount(final int matchingCount) {
        return (int) lottoTickets.stream()
                .map(lottoDiscriminator::matchingCount)
                .filter(e -> e == matchingCount)
                .count();
    }

    public int threeMatchingLottoTicketsCount() {
        return matchingLottoTicketsCount(3);
    }

    public int fourMatchingLottoTicketsCount() {
        return matchingLottoTicketsCount(4);
    }

    public int fiveMatchingLottoTicketsCount() {
        return matchingLottoTicketsCount(5);
    }

    public int sixMatchingLottoTicketsCount() {
        return matchingLottoTicketsCount(6);
    }

    public double yield(int payment) {
        final long threeMatchingLottoTicketsPrize = THREE_MATCHING_PRIZE * threeMatchingLottoTicketsCount();
        final long fourMatchingLottoTicketsPrize = FOUR_MATCHING_PRIZE * fourMatchingLottoTicketsCount();
        final long fiveMatchingLottoTicketsPrize = FIVE_MATCHING_PRIZE * fiveMatchingLottoTicketsCount();
        final long sixMatchingLottoTicketsPrize = SIX_MATCHING_PRIZE * sixMatchingLottoTicketsCount();

        final long totalPrize = threeMatchingLottoTicketsPrize + fourMatchingLottoTicketsPrize +
                fiveMatchingLottoTicketsPrize + sixMatchingLottoTicketsPrize;

        return (double) totalPrize / payment;
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
