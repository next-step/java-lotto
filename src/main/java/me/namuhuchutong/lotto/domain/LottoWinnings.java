package me.namuhuchutong.lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.stream.Stream;

public enum LottoWinnings {

    THREE(3, 5_000),
    FOUR(4,50_000),
    FIVE(5, 1_500_000),
    BONUS(5, 30000000),
    SIX(6, 2_000_000_000);

    private final long count;
    private final long winnings;

    LottoWinnings(long count, long winnings) {
        this.count = count;
        this.winnings = winnings;
    }

    public long getCount() {
        return count;
    }

    public long getWinnings() {
        return winnings;
    }

    private static final Map<Long, Long> BY_COUNT = Stream.of(values())
                                                          .collect(toMap(
                                                                  LottoWinnings::getCount,
                                                                  LottoWinnings::getWinnings));

    public static long valueOfCount(LottoCount lottoCount) {
        return BY_COUNT.get(lottoCount.getCount());
    }
}
