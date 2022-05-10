package lotto;

import java.util.*;

public class LottoResults {
    private final Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);

    public void add(Rank rank) {
        lottoResult.put(rank, getWinningCount(rank) + 1);
    }

    public int getWinningCount(Rank rank) {
        return Optional.ofNullable(lottoResult.get(rank)).orElse(0);
    }
}
