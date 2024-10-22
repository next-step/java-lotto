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

    public static LottoRank from(Integer matchingCount, Boolean isBonusBallMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchingCounts.contains(matchingCount))
                .findAny()
                .map(lottoRank -> lottoRank.match(matchingCount, isBonusBallMatched))
                .orElseThrow(() -> new IllegalArgumentException(String.format("로또 번호 매칭 갯수 '%s'은 적합하지 않습니다.", matchingCount)));
    }

    private LottoRank match(Integer matchingCount, Boolean isBonusBallMatched) {
        if (SECOND.matchingCounts.contains(matchingCount)) {
            return isBonusBallMatched.equals(SECOND.isBonusBallMatching) ? SECOND : THIRD;
        }
        return this;
    }

    public static LottoRank[] winningRanks() {
        return new LottoRank[]{FIFTH, FOURTH, THIRD, SECOND, FIRST};
    }

    public Integer getWinningRankMatchingCount() {
        if (LottoRank.NON_RANKED.equals(this)) {
            throw new IllegalArgumentException("로또 등수에 포함되는 값만 호출해주세요.");
        }
        return this.matchingCounts.get(0);
    }

    public int getDistributionRatioPrice() {
        return distributionRatioPrice;
    }
}
