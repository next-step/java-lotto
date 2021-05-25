package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Award {
    public static final int INITIALIZE_NUMBER = 0;

    private Award() {
    }

    public static Map<Integer, Integer> makePrizes(List<Reward> rewards) {
        TreeMap<Integer, Integer> prizes = new TreeMap<>();

        for (Reward reward : Reward.values()) {
            prizes.put(reward.getPrizeMoney(), INITIALIZE_NUMBER);
        }

        for (Reward reward : rewards) {
            prizes.replace(reward.getPrizeMoney(), prizes.get(reward.getPrizeMoney()) + 1);
        }

        return prizes;
    }

    public static Integer makePrizeMoney(Map<Integer, Integer> prizes) {
        Integer prizeMoney = INITIALIZE_NUMBER;

        for (Reward reward : Reward.values()) {
            prizeMoney += reward.getPrizeMoney() * prizes.get(reward.getPrizeMoney());
        }

        return prizeMoney;
    }

    public static Double makeYield(Integer purchaseAmount, Integer prizeMoney) {
        return prizeMoney / (double) purchaseAmount;
    }
}
