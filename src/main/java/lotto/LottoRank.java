package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3);

    private int lottoMatchingCount;

    LottoRank(int lottoMatchingCount) {
        this.lottoMatchingCount = lottoMatchingCount;
    }

    public static int convertMatchingCountToRank(int matchingCount) {
        return Arrays.stream(values()).filter(i -> i.lottoMatchingCount == matchingCount)
                .mapToInt(i -> 7 - i.lottoMatchingCount).findFirst().orElse(0);
    }

}
