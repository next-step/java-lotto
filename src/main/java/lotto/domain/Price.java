package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Price {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private final int price;

    public Price(int price) {
        validateMinimumPrice(price);
        validateUnitPrice(price);
        this.price = price;
    }

    private void validateMinimumPrice(int price) {
        if (price < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("금액은 1000원 이상 입력해주세요.");
        }
    }

    private void validateUnitPrice(int price) {
        if (price % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위로 입력해주세요.");
        }
    }

    public int getAvailableBuyTicketCount() {
        return price / LOTTO_TICKET_PRICE;
    }

    public BigDecimal getYield(double totalWinningMoney) {
        BigDecimal winningMoney = BigDecimal.valueOf(totalWinningMoney);
        BigDecimal bigDecimalPrice = new BigDecimal(String.valueOf(price));
        return winningMoney.divide(bigDecimalPrice, 2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
