package domain.wrapper;

public class BuyLotto extends PlusNumber {
    public BuyLotto(int number) {
        super(number * LOTTO_PRICE);
    }
    public int getLottoCount() {
        return super.getNumber() / LOTTO_PRICE;
    }
}
