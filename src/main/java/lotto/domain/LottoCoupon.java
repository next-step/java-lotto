package lotto.domain;

import lotto.factories.LottoTicketFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoCoupon {
    private final int exchangeableTicketsCount;

    public LottoCoupon(int exchangeableTicketsCount) {
        this.exchangeableTicketsCount = exchangeableTicketsCount;
    }

    public boolean exchangeable(int count) {
        return exchangeableTicketsCount >= count;
    }

    public LottoBuyer lottoBuyer() {
        return lottoBuyer(new ArrayList<>());
    }

    public LottoBuyer lottoBuyer(List<LottoTicket> manualLottoTickets) {
        return new LottoBuyer(
                manualLottoTickets,
                Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                        .limit(exchangeableTicketsCount - manualLottoTickets.size())
                        .collect(Collectors.toList())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCoupon that = (LottoCoupon) o;
        return exchangeableTicketsCount == that.exchangeableTicketsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchangeableTicketsCount);
    }
}
