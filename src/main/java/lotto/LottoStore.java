package lotto;

public class LottoStore {

    public static Lotto purchase(Money money) {
        if (money.amount() < 1000) {
            throw new IllegalStateException("1000원 이상 있어야 구매할 수 있습니다");
        }
        money.spend(1000);
        return LottoFactory.generate();
    }
}
