package lotto.model;

public class Money {
    private static final int LOTTO_COST = 1000;

    private final int money;

    public Money(Integer money) {
        isNullCost(money);
        minimalMoney(money);
        this.money = money;
    }

    private void isNullCost(Integer money) {
        if (money == null) {
            throw new IllegalArgumentException("알맞은 금액을 입력해주세요.");
        }
    }

    private void minimalMoney(Integer money) {
        if (money < LOTTO_COST) {
            throw new IllegalArgumentException("로또를 한장도 구매할 수 없습니다.");
        }
    }

    public int getMoney() {
        return this.money;
    }
}
