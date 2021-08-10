package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSE(Arrays.asList(2, 1, 0), 0);

    private final List<Integer> correctCount;
    private final Money winningPrice;

    LottoResult(List<Integer> correctCount, int winningPrice) {
        this.correctCount = correctCount;
        this.winningPrice = new Money(winningPrice);
    }

    LottoResult(int winningCount, int winningPrice) {
        this(Arrays.asList(winningCount), winningPrice);
    }

    public static LottoResult from(int winningCount) {
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.correctCount.contains(winningCount)) {
                return lottoResult;
            }
        }

        throw new IllegalArgumentException(winningCount + " 는 잘못된 correctCount 입니다!");
    }
}
