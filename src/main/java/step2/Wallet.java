package step2;

public class Wallet {

    private final Integer money;

    private Wallet(Integer money) {
        this.money = money;
    }

    public int currentMoney() {
        return money;
    }

    public static Wallet save(Integer money) {
        return new Wallet(money);
    }
}
