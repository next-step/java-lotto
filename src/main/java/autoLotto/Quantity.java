package autoLotto;

public class Quantity {

    private int quantity;

    public Quantity(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력할 수 있습니다.");
        }

        this.quantity = amount / 1000;
    }

    public int getQuantity() {
        return quantity;
    }
}
