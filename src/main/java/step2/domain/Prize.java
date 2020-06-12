package step2.domain;

import java.util.Arrays;
import java.util.Optional;

/*
 * LOTTO GAME
 * Prize
 * ver. 1.0
 * 2020.05.31

 */
public enum Prize {

    PRIZE0(0),
    PRIZE1(1),
    PRIZE2(2),
    PRIZE3(3),
    PRIZE4(4),
    PRIZE5(5),
    PRIZE6(6);

    private int matchedNumber;
    private int prizePrice;
    private int prizeCount; // int initial value = 0

    // constructor
    Prize(int matchedNumber) {
        this.matchedNumber = matchedNumber;
    }

    public static Prize of(int matchedNumber, int prizePrice) {

        if (matchedNumber < 0) {
            throw new IllegalArgumentException();
        }

        Optional<Prize>
                prize = Arrays.stream(Prize.values()).
                filter(x -> x.getMatchedNumber() == matchedNumber).
                findFirst();

        prize.get().prizePrice = prizePrice;

        return prize.orElseThrow(IllegalArgumentException::new);

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

