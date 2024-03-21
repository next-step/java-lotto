package lotto;

import java.util.Arrays;
import java.util.List;

public enum LottoPrize {
    FOURTH(3L, 5000L),
    THIRD(4L, 50000L),
    SECOND(5L, 1500000L),
    FIRST(6L, 2000000000L);


    LottoPrize(Long matchCount, Long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoPrize createPrize(long count) {
        return Arrays.stream(values())
                .filter(item -> item.matchCount.equals(count))
                .findAny()
                .orElse(null);
    }

    public Long getMatchCount() {
        return matchCount;
    }

    public Long getPrize() {
        return prize;
    }


    private final Long matchCount;
    private final Long prize;

    public boolean equalsPrize(LottoPrize lottoPrize) {
        if(lottoPrize == null){
            return false;
        }
        return this.equals(lottoPrize);
    }
}

