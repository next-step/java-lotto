package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Price {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private int price;

    public Price(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("금액은 1000원 이상 입력해주세요.");
        }
        if (price % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위로 입력해주세요.");
        }
    }

    public int getAvailableBuyTicketCount() {
        return price / LOTTO_TICKET_PRICE;
    }

    public double getYield(List<Rank> ranks) {
        LottoResult result = new LottoResult(ranks);
        double totalWinningMoney = result.getTotalWinningMoney();
        return Math.floor(totalWinningMoney / price * 100) / 100.0;
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
