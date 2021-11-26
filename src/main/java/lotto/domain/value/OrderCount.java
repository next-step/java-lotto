package lotto.domain.value;

import java.util.Objects;

public class OrderCount {

    private static final int MIN_ORDER_COUNT = 1;
    private static final String MIN_MONEY_ERROR_MSG = "로또 살수 있는 최소 금액은 1000원 입니다!!";

    private final int lottoCount;

    public OrderCount(int orderCount) {

        if (orderCount < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException(MIN_MONEY_ERROR_MSG);
        }

        this.lottoCount = orderCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderCount that = (OrderCount) o;
        return lottoCount == that.lottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoCount);
    }
}
