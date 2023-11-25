package lotto.domain;

public class UserInput {
    private final int money;

    public UserInput(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int floorDivMoney() {
        return Math.floorDiv(this.money, 1000);
    }
}
