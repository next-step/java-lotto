package autoLotto;

public class Quantity {
    private static final int LOTTO_PRICE = 1000;

    private final int quantity;

    public Quantity(final int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력할 수 있습니다.");
        }

        this.quantity = amount / LOTTO_PRICE;
    }

    public int getQuantity() {
        return quantity;
    }
}
