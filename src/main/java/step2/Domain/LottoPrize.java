package step2.Domain;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(2_000_000_000, new HitCount(6)),
    SECOND(10_000_000, new HitCount(5, true)),
    THIRD(1_500_000, new HitCount(5)),
    FOURTH(50_000, new HitCount(4)),
    FIFTH(5_000, new HitCount(3)),
    BLANK(0);

    private long prize;
    private HitCount hitCount;

    LottoPrize(long prize) {
        this(prize, new HitCount(0));
    }

    LottoPrize(long prize, HitCount hitCount) {
        this.prize = prize;
        this.hitCount = hitCount;
    }

    public static LottoPrize getPrizeInfoByHitCount(HitCount hitCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.hitCount.equals(hitCount))
                .findAny()
                .orElse(BLANK);
    }

    public long prize() {
        return prize;
    }

}
