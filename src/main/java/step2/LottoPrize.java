package step2;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(2000000000,new HitCount(6)),
    SECOND(10000000,new HitCount(5,true)),
    THIRD(1500000,new HitCount(5)),
    FOURTH(50000,new HitCount(4)),
    FIFTH(5000,new HitCount(3)),
    BLANK(0);

    private long rank;
    private long prize;
    private HitCount hitCount;

    LottoPrize(long prize){
        this(prize,new HitCount(0));
    }

    LottoPrize(long prize,HitCount hitCount){
        this.prize = prize;
        this.hitCount = hitCount;
    }

    public static LottoPrize getPrizeInfoByHitCount(HitCount hitCount){
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.hitCount.equals(hitCount))
                .findAny()
                .orElse(BLANK);
    }

}
