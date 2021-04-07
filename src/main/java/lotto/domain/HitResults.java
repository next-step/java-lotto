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
        return hitResults.stream()
                .mapToInt(HitResult::getPrizeMoney)
                .sum();
    }

    public long countPrize(Prize prize) {
        return hitResults.stream()
                .filter(hitResult ->
                        hitResult.equalPrize(prize))
                .count();
    }
}
