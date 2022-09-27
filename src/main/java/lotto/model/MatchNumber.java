package lotto.model;

import java.util.Arrays;


public enum MatchNumber {


    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final Integer count;

    private final Integer money;

    MatchNumber(Integer count, Integer money) {
        this.count = count;
        this.money = money;
    }

    public static MatchNumber getMatchNumber(Integer count) {
        return Arrays.stream(values()).filter((matchNumber -> matchNumber.count == count)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static boolean hasMoney(MatchNumber matchNumber) {
        return !(matchNumber.equals(ONE) || matchNumber.equals(TWO) || matchNumber.equals(ZERO));
    }

    public Integer getCount() {
        return count;
    }

    public Integer getMoney() {
        return money;
    }
}
