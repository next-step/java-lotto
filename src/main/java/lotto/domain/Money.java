package lotto.domain;

public class Money {
    private final int money;
    public Money(String money) {
        try {
            this.money = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
    public int getMoney() {
        return this.money;
    }
    public double calculateRate(int winningMoney) {
        return winningMoney / this.money;
    }
}
