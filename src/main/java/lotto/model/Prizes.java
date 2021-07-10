package lotto.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Prizes {
    public static final int INITIALIZE_NUMBER = 0;

    private final Map<Reward, Integer> prizes;

    public Prizes(List<Reward> rewards) {
        this.prizes = makePrizes(rewards);
    }

    private Map<Reward, Integer> makePrizes(List<Reward> rewards) {
        Map<Reward, Integer> prizes = new TreeMap<>();

        for (Reward reward : Reward.values()) {
            prizes.put(reward, INITIALIZE_NUMBER);
        }

        for (Reward reward : rewards) {
            prizes.replace(reward, prizes.get(reward) + 1);
        }

        return prizes;
    }

    private int makePrizeMoney() {
        int prizeMoney = INITIALIZE_NUMBER;

        for (Reward reward : Reward.values()) {
            prizeMoney += reward.getPrizeMoney() * prizes.get(reward);
        }

        return prizeMoney;
    }

    public BigDecimal makeYield(int purchaseAmount) {
        BigDecimal prizeMoney = BigDecimal.valueOf(makePrizeMoney());

        return prizeMoney.divide(BigDecimal.valueOf(purchaseAmount));
    }

    public Map<Reward, Integer> getPrizes() {
        return Collections.unmodifiableMap(prizes);
    }
}
