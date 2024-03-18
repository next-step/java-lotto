package lotto.domain;

import lotto.data.LottoWinInfo;

import java.util.HashMap;
import java.util.Map;

import static lotto.util.ConstUtils.*;

public class LottoMatchedCalculator {

    private final Map<Integer, Integer> matchedMap = new HashMap<>();

    public LottoMatchedCalculator() {
        this.matchedMap.put(LottoWinInfo.WIN_FOURTH.getMatchedCount(), NOTHING_MATCHED);
        this.matchedMap.put(LottoWinInfo.WIN_THIRD.getMatchedCount(), NOTHING_MATCHED);
        this.matchedMap.put(LottoWinInfo.WIN_SECOND.getMatchedCount(), NOTHING_MATCHED);
        this.matchedMap.put(LottoWinInfo.WIN_FIRST.getMatchedCount(), NOTHING_MATCHED);
    }

    public void saveMatched(int matched) {
        this.matchedMap.replace(matched, this.matchedMap.get(matched) + INCREASE);
    }

    public int countMatchedThree() {
        return this.matchedMap.get(LottoWinInfo.WIN_FOURTH.getMatchedCount());
    }

    public int countMatchedFour() {
        return this.matchedMap.get(LottoWinInfo.WIN_THIRD.getMatchedCount());
    }

    public int countMatchedFive() {
        return this.matchedMap.get(LottoWinInfo.WIN_SECOND.getMatchedCount());
    }

    public int countMatchedSix() {
        return this.matchedMap.get(LottoWinInfo.WIN_FIRST.getMatchedCount());
    }

    public double earnRate(int purchasedMoney) {
        return this.winningMoney() / purchasedMoney;
    }

    private double winningMoney() {
        return this.countMatchedThree() * LottoWinInfo.WIN_FOURTH.getWinningPrice() +
                this.countMatchedFour() * LottoWinInfo.WIN_THIRD.getWinningPrice() +
                this.countMatchedFive() * LottoWinInfo.WIN_SECOND.getWinningPrice() +
                this.countMatchedSix() * LottoWinInfo.WIN_FIRST.getWinningPrice();
    }
}
