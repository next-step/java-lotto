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

    MISS(0, 0, "미당첨", false),
    SEVENTH(1, 0, "미당첨", false),
    SIXTH(2, 0, "미당첨", false),
    FIFTH(3, 5_000, "5등", false),
    FOURTH(4, 50_000, "4등", false),
    THIRD(5, 1_500_000, "3등", false),
    SECOND(5, 30_000_000, "2등", true),
    FIRST(6, 2_000_000_000, "1등", false);

    private int matchedNumber;
    private int prizePrice;
    private String rank;
    private int prizeCount; // int initial value = 0

    private boolean bonusNumberMatching;

    // constructor
    Prize(int matchedNumber, int prizePrice, String rank, boolean bonusNumberMatching) {
        this.matchedNumber = matchedNumber;
        this.prizePrice = prizePrice;
        this.rank = rank;
        this.bonusNumberMatching = bonusNumberMatching;
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

    public boolean isBonusNumberMatching() {
        return bonusNumberMatching;
    }

    public static Prize valueOf(int matchedNumber, boolean bonusNumberMatching) {

        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchedNumber() == matchedNumber
                        && prize.isBonusNumberMatching() == bonusNumberMatching
                )
                .findFirst()
                .get();
    }

}










