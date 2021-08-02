package step2;

import java.util.Objects;

public class Wallet {

    private Money cache;

    public Wallet(Money cache) {
        this.cache = cache;
    }

    public void save(Money cache) {
        this.cache = cache.sum(cache);
    }

    public Money currentMoney() {
        return cache;
    }

    public Money withDraw(Money cache) {
        currentMoney().minus(cache);
        return currentMoney();
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
