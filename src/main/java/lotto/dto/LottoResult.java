package lotto.dto;

import lotto.enums.LottoRank;

import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> countByLottoRank;

    public LottoResult(Map<LottoRank, Integer> countByLottoRank) {
        this.countByLottoRank = countByLottoRank;
    }

    public int getCountByRank(LottoRank rank) {
        return countByLottoRank.getOrDefault(rank, 0);
    }

    public int getAllReward() {
        return countByLottoRank.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }
}
