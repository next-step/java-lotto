package step2;

public enum Prize {
    FIRST_PRIZE(2000000000), SECOND_PRIZE(1500000), THIRD_PRIZE(50000), FORTH_PRIZE(5000);

    private int money;

    Prize (int money) {
        this.money = money;
    }

    public int getMoney () {
        return money;
    }

}
