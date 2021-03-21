package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {
    private static final int DEFAULT_PRICE = 1000;

    private final int price;

    public LottoStore() {
        this(DEFAULT_PRICE);
    }

    public LottoStore(int price) {
        this.price = price;
    }

    public List<LottoTicket> lottoTickets(int payment) {
        if (payment < 0) {
            throw new IllegalArgumentException();
        }

        return Stream.generate(this::autoCreatedLottoTicket)
                .limit(payment / price)
                .collect(Collectors.toList());
    }

    private LottoTicket autoCreatedLottoTicket() {
        return new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
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
