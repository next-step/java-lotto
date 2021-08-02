package step2;

import java.util.Objects;

public class Wallet {

    private static final String NEGATIVE_MONEY_EXCEPTION = "지갑은 음수가 될 수 없습니다.";

    private final Integer money;

    private Wallet(Integer money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(Integer money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_EXCEPTION);
        }
    }

    public int currentMoney() {
        return money;
    }

    public static Wallet save(Integer money) {
        return new Wallet(money);
    }

    public Wallet withDraw(Integer money) {
        return save(this.money - money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wallet wallet = (Wallet) o;
        return Objects.equals(money, wallet.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
