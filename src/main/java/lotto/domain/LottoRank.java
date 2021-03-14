package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int matchingCount;
    private int matchingPrice;

    LottoRank (int matchingCount, int matchingPrice) {
        this.matchingCount = matchingCount;
        this.matchingPrice = matchingPrice;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getMatchingPrice() {
        return matchingPrice;
    }

    public static LottoRank findByMatchingCount(int matchingCount) {

        return Arrays.stream(values())
                .filter(r -> r.match(matchingCount))
                .findFirst()
                .orElse(MISS);
    }

    private boolean match(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

}
