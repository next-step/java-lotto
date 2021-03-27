package lotto.domain;

import java.util.Objects;

public class LottoTicketPrice {

    private static final int STANDARD_PRICE = 1000;
    private final int lottoTicketPrice;

    public LottoTicketPrice() {
        this.lottoTicketPrice = STANDARD_PRICE;
    }

    public int price() {
        return lottoTicketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicketPrice that = (LottoTicketPrice) o;
        return lottoTicketPrice == that.lottoTicketPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicketPrice);
    }
}
