package step2;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(1,2000000000,new HitCount(6)),
    SECOND(2,10000000,new HitCount(5,true)),
    THIRD(3,1500000,new HitCount(5)),
    FOURTH(4,50000,new HitCount(4)),
    FIFTH(5,5000,new HitCount(3)),
    BLANK(6,0);

    private long rank;
    private long prize;
    private HitCount hitCount;

    LottoPrize(long rank,long prize){
        this(rank,prize,new HitCount(0));
    }

    LottoPrize(long rank,long prize,HitCount hitCount){
        this.rank = rank;
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
