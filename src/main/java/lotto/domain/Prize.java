package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST(new HitCount(6), new Money(2_000_000_000)),
    SECOND(new HitCount(5, true), new Money(30_000_0000)),
    THIRD(new HitCount(5), new Money(1_500_000)),
    FOURTH(new HitCount(4), new Money(50_000)),
    FIFTH(new HitCount(3), new Money(5_000)),
    NO_PRIZE(new HitCount(0), new Money(0)),
    ;

    private final HitCount hitCount;
    private final Money prizeMoney;

    Prize(HitCount hitCount, Money prizeMoney) {
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

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    public HitCount getHitCount() {
        return hitCount;
    }
}
