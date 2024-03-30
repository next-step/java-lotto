package lotto.domain;

public class Cash {

    private static final int MINIMUM_MONEY = 1000;
    private final int money;

    public Cash(int money) {
        this.money = money;
    }

    public int getAmount() {
        if (money < MINIMUM_MONEY) throw new IllegalArgumentException();
        return money / MINIMUM_MONEY;
    }

    public int minus(Integer count) {
        int result = getAmount() - count;
        if(result < 0){
            throw new IllegalArgumentException();
        }
        return result;
    }
}
