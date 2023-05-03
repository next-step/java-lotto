package lotto.domain;

import lotto.domain.exception.InvalidLottoMatchingCountException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchingCount;
    private final long prize;

    LottoPrize(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public long getPrize() {
        return prize;
    }

    public long getTotalPrize(long count) {
        return prize * count;
    }

    public static LottoPrize from(int matchingCount, boolean isMatchingBonus) {
        checkMatchingCount(matchingCount);

        if (matchingCount < FIFTH.matchingCount) {
            return NONE;
        }

        List<LottoPrize> lottoPrizeList = Arrays.stream(LottoPrize.values())
                .filter(it -> it.matchingCount == matchingCount)
                .collect(Collectors.toList());

        if (lottoPrizeList.size() == 1) {
            return lottoPrizeList.get(0);
        }

        return isMatchingBonus ? SECOND : THIRD;
    }

    private static void checkMatchingCount(int matchingCount) {
        if (matchingCount < 0 || matchingCount > Lotto.LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoMatchingCountException(
                    "입력한 갯수 : ",
                    String.valueOf(matchingCount)
            );
        }
    }
}
