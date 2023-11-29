package lotto.domain;

public class UserInput {
    private final int money;
    private final int passiveNumber;

    public UserInput(int money, int passiveNumber) {
        this.money = money;
        this.passiveNumber = passiveNumber;
    }

    public int getMoney() {
        return money;
    }

    public int getFloorDivCount() {
        return Math.floorDiv(this.money, 1000);
    }

    public int getPassiveNumber() {
        return this.passiveNumber;
    }

    public int getAutoCount() {
        return Math.subtractExact(this.getFloorDivCount(), this.passiveNumber);
    }
}
