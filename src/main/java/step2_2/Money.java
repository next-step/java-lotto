package step2_2;

public class Money {

    private int money;

    public Money(int money) {
        checkPositive(money);
        this.money = money;
    }

    private void checkPositive(int money) {
        if (money < 0) {
            throw new InvalidMoneyInputException();
        }
    }
}
