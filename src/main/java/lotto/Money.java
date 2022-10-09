package lotto;

public class Money {

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        valid(money);
        return new Money(money);
    }

    private static void valid(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 0 미만으로 입력할 수 없습니다.");
        }
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
