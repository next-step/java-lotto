package step2.Domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoPrize {

    FIRST(2_000_000_000, new HitCount(6), (matchBonus, hitCount) -> hitCount.equals(new HitCount(6))),
    SECOND(10_000_000, new HitCount(5), (matchBonus, hitCount) -> matchBonus && hitCount.equals(new HitCount(5))),
    THIRD(1_500_000, new HitCount(5), (matchBonus, hitCount) -> hitCount.equals(new HitCount(5))),
    FOURTH(50_000, new HitCount(4), (matchBonus, hitCount) -> hitCount.equals(new HitCount(4))),
    FIFTH(5_000, new HitCount(3), (matchBonus, hitCount) -> hitCount.equals(new HitCount(3))),
    BLANK(0, new HitCount(0), (matchBonus, hitCount) -> hitCount.equals(new HitCount(0)));

    private long prize;
    private HitCount hitCount;
    private BiFunction<Boolean, HitCount, Boolean> biFunction;

    LottoPrize(long prize, HitCount hitCount, BiFunction<Boolean, HitCount, Boolean> biFunction) {
        this.prize = prize;
        this.hitCount = hitCount;
        this.biFunction = biFunction;
    }

    public static LottoPrize valueOf(HitCount hitCount, boolean matchBonus) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.filter(matchBonus, hitCount))
                .findAny()
                .orElse(BLANK);
    }

    public long prize() {
        return prize;
    }

    public HitCount hitCount() {
        return hitCount;
    }

    private Boolean filter(Boolean matchBonus, HitCount hitCount) {
        return biFunction.apply(matchBonus, hitCount);
    }
}
