package lotto.domain;

public class Purchase {
    private static final int COST = 1000;
    public int calculate(int money) {
        if (money < COST) {
            throw new IllegalArgumentException("구매 금액은 1000원 이상이어야 합니다.");
        }
        return money / COST;
    }
}
