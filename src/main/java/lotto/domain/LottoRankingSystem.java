package lotto.domain;

import java.util.Arrays;

public enum LottoRankingSystem {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchingCount;
    private final int distributionRatioPrice;

    LottoRankingSystem(int matchingCount, int distributionRatioPrice) {
        this.matchingCount = matchingCount;
        this.distributionRatioPrice = distributionRatioPrice;
    }

    public static LottoRankingSystem from(int matchingCount) {
        return Arrays.stream(LottoRankingSystem.values())
                .filter(value -> value.getMatchingCount() == matchingCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("인자 로또 번호 매칭 갯수 '%s'에 적합한 등수가 없습니다.", matchingCount)));
    }

    public static boolean isNotRankEligible(int matchingCount) {
        return matchingCount < FIFTH.getMatchingCount();
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getDistributionRatioPrice() {
        return distributionRatioPrice;
    }
}