package lotto.domain;

public class UserInput {
    private final int money;
    private final int passiveNumber;

    public UserInput(int money, int passiveNumber) {
        checkValidInput(money, passiveNumber);
        this.money = money;
        this.passiveNumber = passiveNumber;
    }

    private static void checkValidInput(int money, int passiveNumber) {
        if(money < passiveNumber) {
            throw new IllegalArgumentException("입력된 금액보다 큰 수동금액을 살 수 없습니다.");
        }
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
