package lotto.domain;

public class InputMoney {
    private static final int LOTTO_COST = 1000;

    private final int money;

    public InputMoney(int money) {
        validMoney(money);
        this.money = money;
    }

    private void validMoney(int money) {
        if (money < LOTTO_COST) {
            throw new IllegalArgumentException("최소 구입금액은 1000원 이상이어야 합니다.");
        }
    }

    public int getAvailableLottoSize() {
        return money / LOTTO_COST;
    }

    public int getMoney() {
        return money;
    }
}
