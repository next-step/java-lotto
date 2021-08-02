package step2;

import java.util.Objects;

public class Cache implements Money {

    private static final String NEGATIVE_MONEY_EXCEPTION = "돈이 없습니다.";
    private static final Integer ZERO = 0;

    private final Integer money;

    public Cache(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int cache) {
        if (cache < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_EXCEPTION);
        }
    }

    public int money() {
        return money;
    }

    @Override
    public Money sum(Money cache) {
        return new Cache(this.money() + cache.money());
    }

    @Override
    public Money minus(Money other) {
        return new Cache(this.money() - other.money());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cache cache = (Cache) o;
        return Objects.equals(money, cache.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String
    toString() {
        return "Cache{" +
            "money=" + money +
            '}';
    }
}
