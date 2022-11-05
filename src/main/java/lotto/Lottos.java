package lotto;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private int quantity;

    public Lottos(int amount) {
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("1000원단위로 입력 가능합니다.");
        }

        this.quantity = amount / LOTTO_PRICE;
    }


    public int lottoQuantity() {
        return this.quantity;
    }
}
