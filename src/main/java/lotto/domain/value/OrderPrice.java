package lotto.domain.value;

import java.util.Objects;

public class OrderPrice {

    private static final int LOTTO_PRICE = 1000;
    private static final String MIN_MONEY_ERROR_MSG = "1000원 이상 입력해주세요";

    private final int lottoPrice;

    public OrderPrice(int orderPrice) {

        if (orderPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_ERROR_MSG);
        }

        this.lottoPrice = orderPrice;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderPrice that = (OrderPrice) o;
        return lottoPrice == that.lottoPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrice);
    }
}
