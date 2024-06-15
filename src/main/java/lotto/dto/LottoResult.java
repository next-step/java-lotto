package lotto.dto;

import lotto.enums.LottoRank;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> countByLottoRank;

    public LottoResult(Map<LottoRank, Integer> countByLottoRank) {
        this.countByLottoRank = countByLottoRank;
    }

    public Map<LottoRank, Integer> getCountByLottoRank() {
        return new HashMap<>(countByLottoRank);
    }
}
