package step2;

public class Wallet {

    private final Integer money;

    public Wallet(int money) {
        this.money = money;
    }

    public int currentMoney() {
        return money;
    }
}
