package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST(new HitCount(6), new HitMoney(2_000_000_000)),
    SECOND(new HitCount(5), new HitMoney(1_500_000)),
    THIRD(new HitCount(4), new HitMoney(50_000)),
    FOURTH(new HitCount(3), new HitMoney(5_000)),
    ;

    private HitCount hitCount;
    private HitMoney prizeMoney;

    Prize(HitCount hitCount, HitMoney prizeMoney) {
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
    }

    private static final Map<HitCount, Prize> prizeMap = new HashMap<>();

    static {
        for (Prize prize : values()) {
            prizeMap.put(prize.getHitCount(), prize);
        }
    }

    public static Prize findPrize(HitCount hitCount) {
        return prizeMap.get(hitCount);
    }

    public HitMoney getPrizeMoney() {
        return prizeMoney;
    }

    public HitCount getHitCount() {
        return hitCount;
    }
}
