package me.daeho.lotto.domain;

import java.util.Objects;

public class LottoPrice {
    private final static int DEFAULT_PRICE = 1_000;
    private final int unitPrice;

    private LottoPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public static LottoPrice of(int unitPrice) {
        return new LottoPrice(unitPrice);
    }

    public static LottoPrice defaultPrice() {
        return new LottoPrice(DEFAULT_PRICE);
    }

    public int value() {
        return unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrice that = (LottoPrice) o;
        return unitPrice == that.unitPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice);
    }
}

