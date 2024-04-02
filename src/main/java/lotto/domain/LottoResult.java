package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        this.result = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    public void addLottoRank(LottoRank lottoRank) {
        result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1);
    }

    public double getRate(int money) {
        int total = 0;
        for (LottoRank lottoRank : result.keySet()) {
            total += lottoRank.getReward() * result.get(lottoRank);
        }

        return (double)total / money;
    }

    public int getRackCount(LottoRank lottoRank) {
        return result.get(lottoRank);
    }
}
