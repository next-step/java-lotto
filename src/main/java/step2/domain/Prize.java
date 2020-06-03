package step2.domain;

/*
 * LOTTO GAME
 * Prize
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class Prize {

    private int matchedNumber;
    private int prizePrice;
    private int prizeCount = 0;

    private static Prize prize = null;

    private Prize() {
    }

    private Prize(int matchedNumber, int prizePrice) {
    }

    public static Prize of(int matchedNumber, int prizePrice) {

        if (matchedNumber <= 0 || prizePrice < 0) {
            throw new IllegalArgumentException();
        }

        Prize prize = new Prize();
        prize.matchedNumber = matchedNumber;
        prize.prizePrice = prizePrice;

        return prize;

    }

    public void addCount(int count) {
        this.prizeCount += count;
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

    public int getPrizeTotal() {
        return prizePrice * prizeCount;
    }

}

