package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<LottoRank, Integer> matchResult;

    public LottoResult() {
        this.matchResult = new EnumMap<>(LottoRank.class);

        initializeRankCount();
    }

    private void initializeRankCount() {
        for (LottoRank rank : LottoRank.values()) {
            matchResult.put(rank, 0);
        }
    }

    public void add(LottoRank rank) {
        matchResult.put(rank, matchResult.get(rank) + 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) {
                continue;
            }

            builder.append(rank).append(" - ").append(matchResult.get(rank));
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(matchResult, that.matchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matchResult);
    }
}
