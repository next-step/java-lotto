package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoResult {
    private Map<LottoRank, Integer> result = new HashMap<>();
    private int money;

    public LottoResult(int money) {
        this.money = money;
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

    public double yield() {
        return (double) profit() / money;
    }

    private long profit() {
        long sum = 0;
        for (LottoRank lottoRank : result.keySet()) {
            long totalMoney = lottoRank.getMoney() * result.get(lottoRank);
            sum += totalMoney;
        }
        return sum;
    }
}
