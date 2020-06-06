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

    MATCH0(0, 0, "미당첨"),
    MATCH1(1, 0, "미당첨"),
    MATCH2(2, 0, "미당첨"),
    MATCH3(3, 5_000, "5등"),
    MATCH4(4, 50_000, "4등"),
    MATCH5(5, 1_500_000, "3등", false),
    MATCH5B(5, 30_000_000, "2등", true),
    MATCH6(6, 2_000_000_000, "1등");


    private int matchedNumber;
    private int prizePrice;
    private String rank;
    private int prizeCount; // int initial value = 0
    private boolean bonusNumberMatching;

    // constructor
    Prize(int matchedNumber, int prizePrice, String rank) {
        this.matchedNumber = matchedNumber;
        this.prizePrice = prizePrice;
        this.rank = rank;
        this.bonusNumberMatching = false;
    }

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


    public static Prize valueOf(int matchedNumber, boolean bonusNumberMatching) {

        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchedNumber == matchedNumber
                        && prize.bonusNumberMatching == bonusNumberMatching
                )
                .findFirst()
                .get();
    }


}

