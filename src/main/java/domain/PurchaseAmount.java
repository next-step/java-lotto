package domain;

public class PurchaseAmount {

    private final int value;

    public PurchaseAmount(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int amount) {
        if (amount < Lotto.PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 한다.");
        }
    }

    public int ticketCount() {
        return value / Lotto.PRICE;
    }
}


