package step2.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum RankPrice {
    FIRST_PLACE(6, 2000000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000);

    final private int MATCH_NUMBER;
    final private int WINED_MONEY;

    RankPrice(int MATCH_NUMBER, int WINED_MONEY) {
        this.MATCH_NUMBER = MATCH_NUMBER;
        this.WINED_MONEY = WINED_MONEY;
    }

    public static RankPrice valueOf(int winner) {
        return Arrays.stream(RankPrice.values())
                .filter(rank -> rank.getMatchNumber() == winner)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getMatchNumber() {
        return MATCH_NUMBER;
    }

    public int getWinedMoney() {
        return WINED_MONEY;
    }
}
