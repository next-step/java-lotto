package domain.wrapper;

public class BuyLotto extends PlusNumber {
    private static final int LOTTO_PRICE = 1000;

    public BuyLotto(int number) {
        super(number * LOTTO_PRICE);
    }

    public int getLottoCount() {
        return super.getNumber() / LOTTO_PRICE;
    }
}
