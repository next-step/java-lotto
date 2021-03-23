package lotto.domain;

import lotto.util.MathUtil;

import java.util.HashMap;
import java.util.Map;

public class Stats {
    private final HitResults hitResults;

    public Stats() {
        this(new HitResults());
    }

    public Stats(HitResults hitResults) {
        this.hitResults = hitResults;
    }

    public double returnRate() {
        return MathUtil.roundUp(sumHitMoney() / hitResults.getPayMoney());
    }

    public double sumHitMoney() {
        double sumHitMoney = 0;
        for (HitResult hitResult : hitResults.getHitResults()) {
            sumHitMoney = sumHitMoney + hitResult.hitMoney().toDouble();
        }
        return sumHitMoney;
    }

    public Map<String, Integer> countHitStats() {
        Map<String, Integer> hitStats = new HashMap<>();

        for (Prize prize : Prize.values()) {
            int count = 0;
            count = prizeCount(prize);
            hitStats.put(prize.name(), count);
        }
        return hitStats;
    }

    private int prizeCount(Prize prize) {
        int prizeCount = 0;
        for (HitResult hitResult : hitResults.getHitResults()) {
            prizeCount = prizeCount + hitResult.isHitPrize(prize);
        }
        return prizeCount;
    }
}
