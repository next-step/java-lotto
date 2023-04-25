package step2;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    public int getLottoCnt(int amount) {
        return amount / LOTTO_PRICE;
    }
}
