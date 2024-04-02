package lotto.domain;

import java.util.Arrays;

public class MatchCache {
    private final int[] counts;
    private int bonusCount;

    public MatchCache() {
        this(new int[6], 0);
    }

    public MatchCache(int[] counts, int bonusCount) {
        this.counts = counts;
        this.bonusCount = bonusCount;
    }

    public void save(int matchCount, boolean isBonus) {
        if(matchCount <= 0){
            return;
        }
        if (isBonusLotto(matchCount, isBonus)) {
            this.bonusCount++;
            return;
        }
        this.counts[matchCount - 1]++;
    }

    private boolean isBonusLotto(int matchCount, boolean isBonus) {
        return matchCount == 5 && isBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchCache)) return false;
        MatchCache that = (MatchCache) o;
        return Arrays.equals(counts, that.counts);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(counts);
    }

    public int[] getCounts() {
        return counts;
    }

    public int getBonusCount() {
        return bonusCount;
    }
}
