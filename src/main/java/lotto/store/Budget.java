package lotto.store;

public class Budget {

    private final int budget;

    public Budget(int budget) {
        this.budget = budget;
    }

    public int get() {
        return budget;
    }

    public void isPurchasable(int price) {
        int count = budget / price;
        if (count < 1) {
            throw new IllegalArgumentException(String.format("로또의 개당 가격은 %d 이므로 금액이 부족합니다", price));
        }
    }
}
