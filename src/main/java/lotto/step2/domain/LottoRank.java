package lotto.step2.domain;

import java.util.Arrays;

public enum LottoRank {
    OTHER(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchingCount;
    private final int prizeMoney;
    private final String toString;

    LottoRank(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;

        String numberMatchCountText = String.format("%d개 일치 ", matchingCount);
        String priceText = String.format("(%d원)- ", prizeMoney);

        this.toString = numberMatchCountText + priceText;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoRank findByCount(final int count) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isSameMatchingCount(count))
                .findFirst()
                .orElse(OTHER);
    }

    private boolean isSameMatchingCount(final int count) {
        return matchingCount == count;
    }

    public boolean hasMatchingCount() {
        return matchingCount > 0;
    }

    @Override
    public String toString() {
        return this.toString;
    }
}
