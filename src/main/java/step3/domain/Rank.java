package step3.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public final int numbersToBeMatched;
    public final int winningPrice;

    Rank(int numbersToBeMatched, int winningPrice) {
        this.numbersToBeMatched = numbersToBeMatched;
        this.winningPrice = winningPrice;
    }

    public static Map<Integer, Rank> matchedCountResultMap() {
        Map<Integer, Rank> map = new HashMap<>();
        for (Rank result : Rank.values()) {
            map.put(result.numbersToBeMatched, result);
        }
        return map;
    }

    public static Rank resultOf(int numbersMatched, boolean matchBonus) {
        if (numbersMatched < 3) {
            numbersMatched = 0;
        }
        Rank result = matchedCountResultMap().get(numbersMatched);
        if (result.equals(FOURTH) && matchBonus) {
            result = SECOND;
        }
        return result;
    }

}
