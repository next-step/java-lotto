package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public int prize() {
        int prize = 0;
        for (LottoRank rank : LottoRank.values()) {
            prize += rank.getPrize(rank, matchResult.get(rank));
        }

        return prize;
    }

    @Override
    public String toString() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .map(rank -> rank + " - " + matchResult.get(rank) + "개")
                .collect(Collectors.joining("\n"));
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
