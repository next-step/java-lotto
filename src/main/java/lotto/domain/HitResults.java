package lotto.domain;

import lotto.util.MathUtil;

import java.util.ArrayList;
import java.util.List;

public class HitResults {
    private final List<HitResult> hitResults;

    public HitResults() {
        this.hitResults = new ArrayList<>();
    }

    public void add(HitResult hitResult) {
        this.hitResults.add(hitResult);
    }

    public double returnRate(Money payMoney) {
        return MathUtil.roundUp(sumHitMoney() / payMoney.intValue());
    }

    private double sumHitMoney() {
        HitMoney sumPrizeMoney = new HitMoney(0);
        for (HitResult hitResult : hitResults) {
            sumPrizeMoney = sumPrizeMoney.sum(hitResult.getPrize().prizeMoney());
        }
        return sumPrizeMoney.intValue();
    }

    public long countPrize(Prize prize) {
        return hitResults.stream()
                .filter(hitResult ->
                        hitResult.getPrize()
                                .equals(prize))
                .count();
    }
}
