package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    NON_RANKED(List.of(0, 1, 2), 0, Boolean.FALSE),
    FIFTH(List.of(3), 5_000, Boolean.FALSE),
    FOURTH(List.of(4), 50_000, Boolean.FALSE),
    THIRD(List.of(5), 1_500_000, Boolean.FALSE),
    SECOND(List.of(5), 30_000_000, Boolean.TRUE),
    FIRST(List.of(6), 2_000_000_000, Boolean.FALSE);

    private final List<Integer> matchingCounts;
    private final int distributionRatioPrice;
    private final Boolean isBonusBallMatching;

    LottoRank(List<Integer> matchingCount, int distributionRatioPrice, Boolean isBonusBallMatching) {
        this.matchingCounts = matchingCount;
        this.distributionRatioPrice = distributionRatioPrice;
        this.isBonusBallMatching = isBonusBallMatching;
    }

    public static LottoRank from(int matchingCount, Boolean isBonusBallMatched) {
        return Arrays.stream(LottoRank.winningRanks())
                .filter(value -> value.getMatchingCounts().contains(matchingCount) && value.isBonusBallMatching.equals(isBonusBallMatched))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("로또 번호 매칭 갯수 '%s'은 적합하지 않습니다.", matchingCount)));
    }

    public static LottoRank[] winningRanks() {
        return new LottoRank[]{FIFTH, FOURTH, THIRD, SECOND, FIRST};
    }

    public List<Integer> getMatchingCounts() {
        return matchingCounts;
    }

    public int getDistributionRatioPrice() {
        return distributionRatioPrice;
    }
}
