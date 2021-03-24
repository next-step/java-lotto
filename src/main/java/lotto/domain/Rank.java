package lotto.domain;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;

    private int hitNum, money;

    Rank(int hitNum, int money) {
        this.hitNum = hitNum;
        this.money = money;
    }

    public int getHitNum() {
        return hitNum;
    }

    public int getMoney() {
        return money;
    }

    public static Rank converterPrize(int prizeName) {
        for (Rank prizelist : values()) {
            if (prizeName < WINNING_MIN_COUNT) {
                return MISS;
            }
            if (prizelist.getHitNum() == prizeName) {
                return prizelist;
            }
        }
        throw new IllegalArgumentException("값이 잘못되었습니다. 다시 한번 확인해주세요.");
    }
}
