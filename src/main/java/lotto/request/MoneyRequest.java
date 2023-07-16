package lotto.request;

public class MoneyRequest {

    private final long money;

    public MoneyRequest(long money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }
}
