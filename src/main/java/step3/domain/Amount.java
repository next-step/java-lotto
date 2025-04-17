package step3.domain;

import java.util.Objects;

public class Amount {
    private final Integer amount;

    public Amount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Amount amount1 = (Amount)o;
        return Objects.equals(amount, amount1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }
}
