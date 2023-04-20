package lotto.domain;

import lotto.domain.strategy.LottoStrategy;

import java.util.Objects;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final Amount amount;
    private final LottoList lottoList;

    public LottoMachine(int amount, LottoStrategy lottoStrategy) {
        this.amount = new Amount(amount);
        this.lottoList = new LottoList(this.amount.calculateUnitCount(LOTTO_PRICE), lottoStrategy);
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
