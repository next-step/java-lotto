package lotto.step2.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {
    OTHER("탈락", new RankInfo(0, false, 0)),
    FIFTH("5등", new RankInfo(3, false, 5_000)),
    FOURTH("4등", new RankInfo(4, false, 50_000)),
    THIRD("3등", new RankInfo(5, false, 1_500_000)),
    SECOND("2등", new RankInfo(5, true, 30_000_000)),
    FIRST("1등", new RankInfo(6, false, 2_000_000_000));

    private final String description;
    private final RankInfo rankInfo;
    private final String toString;

    LottoRank(final String description, final RankInfo rankInfo) {
        this.description = description;
        this.rankInfo = rankInfo;

        this.toString = generateToString();
    }

    private String generateToString() {
        StringBuilder sb = new StringBuilder();

        final String matchingCountText = String.format("%d개 일치 ", rankInfo.getMatchingCount());
        final String prizeText = String.format("(%d원)- ", rankInfo.getPrizeMoney());

        sb.append(matchingCountText).append(prizeText);

        if (rankInfo.isBonusMatching()) {
            sb.insert(matchingCountText.length() - 1, ",보너스 볼 일치");
        }

        return sb.toString();
    }

    public String getDescription() {
        return description;
    }

    public int getMatchingCount() {
        return rankInfo.getMatchingCount();
    }

    public boolean isBonusMatching(final boolean isBonusMatching) {
        return rankInfo.isBonusMatching() == isBonusMatching;
    }

    public int getPrizeMoney() {
        return rankInfo.getPrizeMoney();
    }

    public static LottoRank findByCountAndBonusMatching(final int count, final boolean isBonusMatching) {
        return Arrays.stream(values())
                .filter(filterLottoRank(count, isBonusMatching))
                .findFirst()
                .orElse(OTHER);
    }

    private static Predicate<LottoRank> filterLottoRank(final int matchingCount, final boolean isBonusMatching) {
        if (matchingCount == SECOND.getMatchingCount()) {
            return lottoRank -> lottoRank.isSameMatchingCount(matchingCount) && lottoRank.isBonusMatching(isBonusMatching);
        }

        return lottoRank -> lottoRank.isSameMatchingCount(matchingCount);
    }

    private boolean isSameMatchingCount(final int count) {
        return rankInfo.getMatchingCount() == count;
    }

    public boolean hasMatchingCount() {
        return rankInfo.getMatchingCount() > 0;
    }

    @Override
    public String toString() {
        return this.toString;
    }

    private static class RankInfo {
        private final int matchingCount;
        private final boolean isBonusMatching;
        private final int prizeMoney;

        private RankInfo(final int matchingCount, final boolean isBonusMatching, final int prizeMoney) {
            this.matchingCount = matchingCount;
            this.isBonusMatching = isBonusMatching;
            this.prizeMoney = prizeMoney;
        }

        public int getMatchingCount() {
            return matchingCount;
        }

        public boolean isBonusMatching() {
            return isBonusMatching;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }
    }
}
