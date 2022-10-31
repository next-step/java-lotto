package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum LottoWinnerClass {
    FOURTH(3),
    THIRD(4),
    SECOND(5),
    FIRST(6);

    private final int matchingCount;

    LottoWinnerClass(int matchingCount) {
        this.matchingCount = matchingCount;
    }

    public static LottoWinnerClass getByMatchingCount(int matchingCount) {
        Optional<LottoWinnerClass> result = Arrays.stream(values())
                .filter(winnerClass -> winnerClass.hasMatchingCount(matchingCount))
                .findFirst();

        if (result.isEmpty()) {
            throw new IllegalArgumentException("잘못된 매칭 숫자입니다.");
        }

        return result.get();
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean hasMatchingCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }
}
