package lotto.domain;

import java.util.Objects;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final Amount amount;

    public LottoMachine(int amount) {
        this.amount = new Amount(amount);
    }

    public int countNumberOfLottoTickets() {
        return this.amount.calculateUnitCount(LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMachine that = (LottoMachine) o;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
