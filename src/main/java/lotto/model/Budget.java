package lotto.model;

import java.util.Objects;

public class Budget {
    private final int amount;

    public Budget(int amount) {
        if (!isValid(amount)) {
            throw new IllegalArgumentException("예산은 0 이상이며 1000원 단위로만 설정 가능합니다.");
        }
        this.amount = amount;
    }

    public int countLottoTickets() {
        return amount / 1000;
    }

    public Lottos buyLottos() {
        return new Lottos(countLottoTickets());
    }

    public double getReturnRate(Long totalPrize) {
        if (amount == 0) {
            return 0;
        }
        double rate = (double) totalPrize / amount;
        return Math.floor(rate * 100) / 100.0;
    }

    private boolean isValid(int amount) {
        return amount >= 0 && amount % 1000 == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return amount == budget.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }
}
