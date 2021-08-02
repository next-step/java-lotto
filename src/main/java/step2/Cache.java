package step2;

public class Cache implements Money {

    private static final String NEGATIVE_MONEY_EXCEPTION = "돈은 음수가 될 수 없습니다.";

    private final int cache;

    public Cache(int cache) {
        validateMoney(cache);
        this.cache = cache;
    }

    private void validateMoney(int cache) {
        if (cache < 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_EXCEPTION);
        }
    }



    public int money() {
        return cache;
    }

    @Override
    public Money minus(Money other) {
        return new Cache(this.money() - other.money());
    }
}
