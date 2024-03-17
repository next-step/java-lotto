package lotto.domain;

import lotto.util.ConstUtils;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchedCalculator {

    private final Map<Integer, Integer> matchedMap = new HashMap<>();

    public LottoMatchedCalculator() {
        this.matchedMap.put(ConstUtils.MATCHED_THREE, ConstUtils.NOTHING_MATCHED);
        this.matchedMap.put(ConstUtils.MATCHED_FOUR, ConstUtils.NOTHING_MATCHED);
        this.matchedMap.put(ConstUtils.MATCHED_FIVE, ConstUtils.NOTHING_MATCHED);
        this.matchedMap.put(ConstUtils.MATCHED_SIX, ConstUtils.NOTHING_MATCHED);
    }

    public void saveMatched(int matched) {
        this.matchedMap.replace(matched, this.matchedMap.get(matched) + 1);
    }

    public int countMatchedThree() {
        return this.matchedMap.get(ConstUtils.MATCHED_THREE);
    }

    public int countMatchedFour() {
        return this.matchedMap.get(ConstUtils.MATCHED_FOUR);
    }

    public int countMatchedFive() {
        return this.matchedMap.get(ConstUtils.MATCHED_FIVE);
    }

    public int countMatchedSix() {
        return this.matchedMap.get(ConstUtils.MATCHED_SIX);
    }

    public double earnRate(int purchasedMoney) {
        return this.winningMoney() / purchasedMoney;
    }

    private double winningMoney() {
        return this.countMatchedThree() * ConstUtils.WIN_THREE +
                this.countMatchedFour() * ConstUtils.WIN_FOUR +
                this.countMatchedFive() * ConstUtils.WIN_FIVE +
                this.countMatchedSix() * ConstUtils.WIN_SIX;
    }
}
