public class Money {

    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
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
