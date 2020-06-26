package step4.domain.prize;

import java.util.Arrays;

/*
 * LOTTO GAME
 * Prize
 * ver. 1.0
 * 2020.05.31
 */
public enum Prize {

    MISS(0, 0, "미당첨", false),
    FIFTH(3, 5_000, "5등", false),
    FOURTH(4, 50_000, "4등", false),
    THIRD(5, 1_500_000, "3등", false),
    SECOND(5, 30_000_000, "2등", true),
    FIRST(6, 2_000_000_000, "1등", false);

    public static final int MISS_MATCHED_CUT_LINE = 2;
    private int matchedNumber;
    private long prizePrice;
    private String rank;
    private boolean bonusNumberMatching;
    private int matchedCount = 0;

    // constructor
    Prize(int matchedNumber, int prizePrice, String rank, boolean bonusNumberMatching) {
        this.matchedNumber = checkMatchedNumberInCutLine(matchedNumber);
        this.prizePrice = prizePrice;
        this.rank = rank;
        this.bonusNumberMatching = bonusNumberMatching;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public long getPrizePrice() {
        return prizePrice;
    }

    public boolean isBonusNumberMatching() {
        return bonusNumberMatching;
    }

    public static Prize valueOf(int matchedNumber, boolean bonusNumberMatching) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchedNumber == matchedNumber && prize.bonusNumberMatching == bonusNumberMatching)
                .findFirst()
                .orElseGet(() -> MISS);
    }

    private static int checkMatchedNumberInCutLine(int matchedNumber) {
        return matchedNumber <= MISS_MATCHED_CUT_LINE ? 0 : matchedNumber;
    }

    public void addMatchedCount() {
        this.matchedCount += 1;
    }

    public long getPrizePriceSum() {
        return matchedCount;
    }

}
