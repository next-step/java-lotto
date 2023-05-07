package lotto.model;

public class Cost {
    private int money;

    public Cost(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("구입 금액은 음수일 수 없습니다.");
        }
    }


}
