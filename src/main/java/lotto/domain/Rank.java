package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    ELSE(-1, false, 0);

    private int countOfMatch;
    private boolean matchBonus;
    private int price;

    Rank(int countOfMatch, boolean matchBonus, int price) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> (rank.getCountOfMatch() == countOfMatch))
                .filter(rank -> (rank.withBonusNumber() == matchBonus))
                .findAny()
                .orElse(ELSE);
    }

    public static int countOfMatchWhichNeedsBonusNumberCheck() {
        return SECOND.getCountOfMatch();
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean withBonusNumber() {
        return this.matchBonus;
    }
}
