package lotto.step2.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {
    OTHER("탈락", 0, false, 0),
    FIFTH("5등", 3, false, 5_000),
    FOURTH("4등", 4, false, 50_000),
    THIRD("3등", 5, false, 1_500_000),
    SECOND("2등", 5, true, 30_000_000),
    FIRST("1등", 6, false, 2_000_000_000);

    private final String description;
    private final int matchingCount;
    private final boolean isBonusMatching;
    private final int prizeMoney;
    private final String toString;

    LottoRank(final String description, int matchingCount, final boolean isBonusMatching, int prizeMoney) {
        this.description = description;
        this.matchingCount = matchingCount;
        this.isBonusMatching = isBonusMatching;
        this.prizeMoney = prizeMoney;

        this.toString = generateToString();
    }

    private String generateToString() {
        StringBuilder sb = new StringBuilder();

        final String matchingCountText = String.format("%d개 일치 ", matchingCount);
        final String prizeText = String.format("(%d원)- ", prizeMoney);

        sb.append(matchingCountText).append(prizeText);

        if (isBonusMatching) {
            sb.insert(matchingCountText.length() - 1, ",보너스 볼 일치");
        }

        return sb.toString();
    }

    public String getDescription() {
        return description;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonusMatching(final boolean isBonusMatching) {
        return this.isBonusMatching == isBonusMatching;
    }

    public int getPrizeMoney() {
        return prizeMoney;
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
