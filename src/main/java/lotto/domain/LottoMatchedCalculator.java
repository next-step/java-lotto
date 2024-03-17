package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.util.ConstUtils.*;

public class LottoMatchedCalculator {

    private final Map<Integer, Integer> matchedMap = new HashMap<>();

    public LottoMatchedCalculator() {
        this.matchedMap.put(MATCHED_THREE, NOTHING_MATCHED);
        this.matchedMap.put(MATCHED_FOUR, NOTHING_MATCHED);
        this.matchedMap.put(MATCHED_FIVE, NOTHING_MATCHED);
        this.matchedMap.put(MATCHED_SIX, NOTHING_MATCHED);
    }

    public void saveMatched(int matched) {
        this.matchedMap.replace(matched, this.matchedMap.get(matched) + INCREASE);
    }

    public int countMatchedThree() {
        return this.matchedMap.get(MATCHED_THREE);
    }

    public int countMatchedFour() {
        return this.matchedMap.get(MATCHED_FOUR);
    }

    public int countMatchedFive() {
        return this.matchedMap.get(MATCHED_FIVE);
    }

    public int countMatchedSix() {
        return this.matchedMap.get(MATCHED_SIX);
    }

    public double earnRate(int purchasedMoney) {
        return this.winningMoney() / purchasedMoney;
    }

    private double winningMoney() {
        return this.countMatchedThree() * WIN_THREE +
                this.countMatchedFour() * WIN_FOUR +
                this.countMatchedFive() * WIN_FIVE +
                this.countMatchedSix() * WIN_SIX;
    }
}
