package autoLotto;

public class Quantity {
    private static final int DIVIDE_1000_WON = 1000;

    private final int quantity;

    public Quantity(final int amount) {
        if (amount % DIVIDE_1000_WON != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력할 수 있습니다.");
        }

        this.quantity = amount / DIVIDE_1000_WON;
    }

    public int getQuantity() {
        return quantity;
    }
}
