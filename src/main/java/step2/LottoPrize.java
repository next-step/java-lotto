package step2;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(1,2000000000),
    THIRD(3,1500000),
    FOURTH(4,50000),
    FIFTH(5,5000),
    BLANK(6,0);

    private long rank;
    private long prize;

    LottoPrize(long rank,long prize){
        this.rank = rank;
        this.prize = prize;
    }

    public static LottoPrize getPrizeInfo(long rank){
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.rank == rank)
                .findAny()
                .orElse(BLANK);
    }

}
