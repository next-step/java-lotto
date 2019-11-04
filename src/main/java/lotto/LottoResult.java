package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoResult {
    private Map<LottoRank, Integer> result = new HashMap<>();

    public LottoResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    public void update(int count) {
        Optional<LottoRank> lottoRankOptional = LottoRank.getRank(count);
        lottoRankOptional.ifPresent(lottoRank -> {
            int rankCount = Optional.ofNullable(result.get(lottoRank))
                    .orElse(0);
            result.put(lottoRank, rankCount + 1);
        });
    }

    public int rankCount(LottoRank lottoRank) {
        return Optional.ofNullable(result.get(lottoRank))
                .orElse(0);
    }
}
