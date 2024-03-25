package lotto.domain;

import java.util.Arrays;

public class MatchCache {
    private int[] counts = new int[6];

    public MatchCache() {
    }

    public MatchCache(int[] counts) {
        this.counts = counts;
    }

    public void save(int matchCount) {
        this.counts[matchCount - 1]++;
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
}
