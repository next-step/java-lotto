package step3.domain;

import java.util.Arrays;
import java.util.Optional;

/*
 * LOTTO GAME
 * Prize
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public enum Prize {

    MATCH0(0, 0),
    MATCH1(1, 0),
    MATCH2(2, 0),
    MATCH3(3, 5_000),
    MATCH4(4, 50_000),
    MATCH5(5, 1_500_000),
    MATCH6(6, 2_000_000_000);

    private int matchedNumber;
    private int prizePrice;
    private int prizeCount; // int initial value = 0

    // constructor
    Prize(int matchedNumber, int prizePrice) {
        this.matchedNumber = matchedNumber;
        this.prizePrice = prizePrice;
    }

    public static Prize of(int matchedNumber, int prizePrice) {

        return Arrays.stream(Prize.values()).
                filter(x -> x.getMatchedNumber() == matchedNumber).
                findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getPrizeCount() {
        return prizeCount;
    }

    public int getPrizePrice() {
        return prizePrice;
    }

    public long getPrizeTotal() {
        return prizePrice * prizeCount;
    }

    public void addWinning() {
        this.prizeCount += 1;
    }

}

