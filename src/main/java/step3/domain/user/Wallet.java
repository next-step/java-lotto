package step3.domain.user;

import step3.domain.money.Money;
import java.util.Objects;

public class Wallet {

    private Money cache;

    public Wallet(Money cache) {
        this.cache = cache;
    }

    public void save(Money otherCache) {
        this.cache = cache.sum(otherCache);
    }

    public Money currentMoney() {
        return cache;
    }

    public Money withDraw() {
        return withDraw(cache);
    }

    public Money withDraw(Money cache) {
        this.cache = currentMoney().minus(cache);
        return cache;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wallet wallet = (Wallet) o;
        return Objects.equals(cache, wallet.cache);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cache);
    }
}
