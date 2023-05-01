package lotto.domain;

import lotto.domain.exception.InvalidLottoMatchingCountException;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int matchingCount;
    private final long prize;

    LottoPrize(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public static LottoPrize from(int matchingCount) {
        Optional<LottoPrize> lottoPrize = Arrays.stream(LottoPrize.values())
                .filter(it -> it.matchingCount == matchingCount)
                .findFirst();

        if (lottoPrize.isPresent()) {
            return lottoPrize.get();
        }

        throw new InvalidLottoMatchingCountException(
                "입력한 갯수 : ",
                String.valueOf(matchingCount)
        );
    }
}
