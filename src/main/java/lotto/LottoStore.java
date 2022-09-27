package lotto;


public class LottoStore {

    private final int LOTTO_PRICE = 1000;
    public int buy(int input) {
        return input / LOTTO_PRICE;
    }
}