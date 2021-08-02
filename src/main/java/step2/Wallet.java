package step2;

public class Wallet {

    private final Money cache;

    private Wallet(Money cache) {
        this.cache = cache;
    }

    public static Wallet save(Money cache) {
        return new Wallet(cache);
    }


    public Money currentMoney() {
        return cache;
    }

    public Wallet withDraw(Cache cache) {
        return save(this.cache.minus(cache));
    }
}
