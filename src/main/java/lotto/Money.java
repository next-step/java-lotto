package lotto;

public class Money {

    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public Money spend(int money) {
        return new Money(this.money - money);
    }

    public boolean isBigger(int totalLottoPrice){
        return this.money < totalLottoPrice;
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈 액수는 0원 이상이어야 합니다.");
        }
    }

    public int getMoney() {
        return this.money;
    }
}
