package lotto;

public class Money {

    private int money;

    public Money(int money) {
        valid(money);
        this.money = money;
    }

    private void valid(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 0 미만으로 입력할 수 없습니다.");
        }
    }
}
