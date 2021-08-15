package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum LottoPlace {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSE(Arrays.asList(2, 1, 0), 0);

    private final List<Integer> correctCounts;
    private final Money winningPrice;

    LottoPlace(List<Integer> correctCounts, int winningPrice) {
        this.correctCounts = correctCounts;
        this.winningPrice = new Money(winningPrice);
    }

    LottoPlace(int winningCount, int winningPrice) {
        this(Arrays.asList(winningCount), winningPrice);
    }

    public Money getWinningPrice() {
        return winningPrice;
    }

    public Integer getFirstCorrectCount() {
        return correctCounts.get(0);
    }

    public static LottoPlace fromCorrectCount(int correctCount) {
        for (LottoPlace lottoPlace : LottoPlace.values()) {
            if (lottoPlace.correctCounts.contains(correctCount)) {
                return lottoPlace;
            }
        }

        throw new IllegalArgumentException(correctCount + " 는 잘못된 correctCount 입니다!");
    }
}
