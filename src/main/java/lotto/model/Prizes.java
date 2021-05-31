package lotto.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Prizes {
    public static final int INITIALIZE_NUMBER = 0;

    private final Map<Integer, Integer> prizes;
    private final int prizeMoney;

    public Prizes(List<Reward> rewards) {
        this.prizes = makePrizes(rewards);
        this.prizeMoney = makePrizeMoney();
    }

    private Map<Integer, Integer> makePrizes(List<Reward> rewards) {
        Map<Integer, Integer> prizes = new TreeMap<>();

        for (Reward reward : Reward.values()) {
            prizes.put(reward.getPrizeMoney(), INITIALIZE_NUMBER);
        }

        for (Reward reward : rewards) {
            prizes.replace(reward.getPrizeMoney(), prizes.get(reward.getPrizeMoney()) + 1);
        }

        return prizes;
    }

    private int makePrizeMoney() {
        Integer prizeMoney = INITIALIZE_NUMBER;

        for (Reward reward : Reward.values()) {
            prizeMoney += reward.getPrizeMoney() * prizes.get(reward.getPrizeMoney());
        }

        return prizeMoney;
    }

    public BigDecimal makeYield(int purchaseAmount) {
        return BigDecimal.valueOf(this.prizeMoney).divide(BigDecimal.valueOf(purchaseAmount));
    }

    public Map<Integer, Integer> getPrizes() {
        return Collections.unmodifiableMap(prizes);
    }
}
