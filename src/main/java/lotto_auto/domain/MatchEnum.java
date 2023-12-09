package lotto_auto.domain;

public enum MatchEnum {
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 15000000),
    SIX_MATCHES(6, 2000000000);

    private int matches;
    private int money;

    MatchEnum(int matches, int money) {
        this.matches = matches;
        this.money = money;
    }

    public int getMatches() {
        return this.matches;
    }

    public int getMoney() {
        return this.money;
    }
}
