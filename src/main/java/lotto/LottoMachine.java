package lotto;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    private Money money;

    public LottoMachine(int input) {
        this.money = new Money(input);
    }

    public void generateLotto() {
        money.getPurchasableCount(LOTTO_PRICE);
    }
}
