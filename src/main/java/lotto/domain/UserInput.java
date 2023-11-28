package lotto.domain;

public class UserInput {
    private final int money;
    private final int massiveNumber;

    public UserInput(int money, int massiveNumber) {
        this.money = money;
        this.massiveNumber = massiveNumber;
    }

    public int getMoney() {
        return money;
    }

    public int getFloorDivCount() {
        return Math.floorDiv(this.money, 1000);
    }

    public int getMassiveNumber() {
        return this.massiveNumber;
    }

    public int getAutoCount() {
        return Math.subtractExact(this.getFloorDivCount(), this.massiveNumber);
    }
}
