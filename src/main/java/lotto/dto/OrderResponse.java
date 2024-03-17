package lotto.dto;

import lotto.model.Lotto;
import lotto.model.LottoPaper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OrderResponse {
    private final int quantity;
    private final LottoPaper lottoPaper;

    public OrderResponse(int quantity, LottoPaper lottoPaper) {
        this.quantity = quantity;
        this.lottoPaper = lottoPaper;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public List<Lotto> getLottos() {
        return this.lottoPaper.getLottos();
    }

    public Map<Integer, Integer> matches(Lotto other) {
        return this.lottoPaper.matches(other);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        OrderResponse that = (OrderResponse) other;
        return quantity == that.quantity && Objects.equals(lottoPaper, that.lottoPaper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, lottoPaper);
    }
}
