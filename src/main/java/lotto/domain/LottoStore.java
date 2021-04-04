package lotto.domain;

import lotto.factories.LottoTicketFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {
    private static final String PAYMENT_ERROR_MESSAGE = "%d원보다 높은 금액을 입력해야 합니다.";
    private static final int DEFAULT_PRICE = 1000;

    private final int price;

    public LottoStore() {
        this(DEFAULT_PRICE);
    }

    public LottoStore(int price) {
        this.price = price;
    }

    public List<LottoTicket> lottoTickets(int payment) {
        if (payment < price) {
            throw new IllegalArgumentException(String.format(PAYMENT_ERROR_MESSAGE, price));
        }

        return Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                .limit(purchasableCount(payment))
                .collect(Collectors.toList());
    }

    public LottoCoupon lottoCoupon(int payment) {
        if (payment < price) {
            throw new IllegalArgumentException(String.format(PAYMENT_ERROR_MESSAGE, price));
        }

        return new LottoCoupon(purchasableCount(payment));
    }

    public boolean purchasable(int payment, int count) {
        return purchasableCount(payment) >= count;
    }

    public AllLottoTickets allLottoTickets(int payment, List<LottoTicket> manualLottoTickets) {
        return new AllLottoTickets(
                manualLottoTickets,
                Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                        .limit(purchasableCount(payment) - manualLottoTickets.size())
                        .collect(Collectors.toList())
        );
    }

    private int purchasableCount(int payment) {
        return payment / price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStore that = (LottoStore) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

}
