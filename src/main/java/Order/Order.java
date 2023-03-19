package Order;

public class Order {
    private final int money;
    public Order(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("금액은 0보다 커야 합니다");
        }
    }

    public int getMoney() {
        return money;
    }
}
