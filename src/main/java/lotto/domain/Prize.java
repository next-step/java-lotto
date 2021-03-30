package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST(new HitCount(6), new HitMoney(2_000_000_000)),
    SECOND(new HitCount(5, true), new HitMoney(30_000_0000)),
    THIRD(new HitCount(5), new HitMoney(1_500_000)),
    FOURTH(new HitCount(4), new HitMoney(50_000)),
    FIFTH(new HitCount(3), new HitMoney(5_000)),
    NO_PRIZE(new HitCount(0), new HitMoney(0)),
    ;

    private final HitCount hitCount;
    private final HitMoney prizeMoney;

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
        if (hitCount.isNoHitCount()) {
            return Prize.NO_PRIZE;
        }

        if (prizeMap.containsKey(hitCount)) {
            return prizeMap.get(hitCount);
        }
        throw new IllegalArgumentException("당첨갯수가 당첨상금에 없습니다.");
    }

    public HitMoney getPrizeMoney() {
        return prizeMoney;
    }

    public HitCount getHitCount() {
        return hitCount;
    }
}
