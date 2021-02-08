package lotto.wrapper;

public class Budget extends Money{
    private int money;

    public Budget(int money) {
        super(money);
        if (money < 1000) {
            throw new IllegalArgumentException("복권은 1000원 부터 구매 가능합니다.");
        }
        this.money = money;
    }
}
