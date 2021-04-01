package step2.Domain;

import java.util.Arrays;

public enum LottoPrize {
    BLANK(0, new HitCount(0)),
    FIFTH(5_000, new HitCount(3)),
    FOURTH(50_000, new HitCount(4)),
    THIRD(1_500_000, new HitCount(5)),
    SECOND(10_000_000, new HitCount(5)),
    FIRST(2_000_000_000, new HitCount(6));


    private long prize;
    private HitCount hitCount;

    LottoPrize(long prize, HitCount hitCount) {
        this.prize = prize;
        this.hitCount = hitCount;
    }

    public static LottoPrize valueOf(HitCount hitCount, boolean matchBonus) {
        if (matchBonus && LottoPrize.SECOND.hitCount.equals(hitCount)) {
            return LottoPrize.SECOND;
        }
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.hitCount.equals(hitCount))
                .findAny()
                .orElse(BLANK);
    }

    public long prize() {
        return prize;
    }

    public HitCount hitCount() {
        return hitCount;
    }
}
