package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NON_RANKED(2, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchingCount;
    private final int distributionRatioPrice;

    LottoRank(int matchingCount, int distributionRatioPrice) {
        this.matchingCount = matchingCount;
        this.distributionRatioPrice = distributionRatioPrice;
    }

    public static LottoRank from(int matchingCount, Boolean isBonusBallMatched) {
        if (isNotRankEligible(matchingCount)) {
            return NON_RANKED;
        }
        if (isSecondWinner(matchingCount, isBonusBallMatched)) {
            return SECOND;
        }
        return Arrays.stream(LottoRank.winningRanks())
                .filter(value -> value.getMatchingCount() == matchingCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("로또 번호 매칭 갯수 '%s'은 적합하지 않습니다.", matchingCount)));
    }

    private static boolean isSecondWinner(int matchingCount, Boolean isBonusBallMatched) {
        return matchingCount == THIRD.getMatchingCount() && isBonusBallMatched;
    }

    private static boolean isNotRankEligible(int matchingCount) {
        return 0 <= matchingCount && matchingCount <= NON_RANKED.matchingCount;
    }

    public static LottoRank[] winningRanks() {
        return new LottoRank[]{FIFTH, FOURTH, THIRD, SECOND, FIRST};
    }

    public String description() {
        if (LottoRank.SECOND.equals(this)) {
            return String.format("%d개 일치, 보너스 볼 일치", this.getMatchingCount());
        }
        return String.format("%d개 일치", this.getMatchingCount());
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getDistributionRatioPrice() {
        return distributionRatioPrice;
    }
}
