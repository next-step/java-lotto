package lotto.model;

import java.util.Arrays;


public enum MatchNumber {


    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1500_000),
    SIX(6, 2000_000_000);

    private final Integer count;

    private final Integer money;

    MatchNumber(Integer count, Integer money) {
        this.count = count;
        this.money = money;
    }
    public Integer getCount() {
        return count;
    }

    public Integer getMoney() {
        return money;
    }

    public static MatchNumber getMatchNumber(Integer count) {
        return Arrays.stream(values()).filter((matchNumber -> matchNumber.count == count)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static boolean hasMoney(MatchNumber matchNumber) {
        return !(matchNumber.equals(ONE) || matchNumber.equals(TWO) || matchNumber.equals(ZERO));
    }

}
