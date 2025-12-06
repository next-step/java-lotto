package lotto.domain;

public class LottoPurchase {
    private static final long LOTTO_PRICE = 1_000;

    private final LottoCount count;

    public LottoPurchase(Money money) {
        this(new LottoCount(calculateCount(money)));
    }

    public LottoPurchase(LottoCount count) {
        this.count = count;
    }

    private static int calculateCount(Money money) {
        return (int)(money.getMoney() / LOTTO_PRICE);
    }

    public int count() {
        return count.value();
    }
}
