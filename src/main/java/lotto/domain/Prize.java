package lotto.domain;

public enum Prize {
    UNRANKED(0, 0),
    COINCIDE_THREE(3, 5000),
    COINCIDE_FOUR(4, 50000),
    COINCIDE_FIVE(5, 1500000),
    COINCIDE_SIX(6, 2000000000);

    private final int number;
    private final int money;

    Prize(int number, int money) {
        this.number = number;
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public int getMoney() {
        return money;
    }

    public static Prize award(Lotto winLotto, Lotto lotto) {
        return UNRANKED;
    }
}
