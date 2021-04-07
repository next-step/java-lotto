package lotto.domain;

import java.util.Objects;

public class HitMoney {
    private final int hitMoney;

    public HitMoney(int hitMoney) {
        this.hitMoney = hitMoney;
    }

    public int intValue() {
        return hitMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitMoney hitMoney1 = (HitMoney) o;
        return hitMoney == hitMoney1.hitMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitMoney);
    }

    public HitMoney sum(int hitMoney) {
        return new HitMoney(this.hitMoney + hitMoney);
    }
}
