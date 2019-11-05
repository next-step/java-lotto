package lotto.domain;

import java.util.*;

public class LottoResult {
    private static final int DEFAULT_RESULT_COUNT = 0;
    private static final int OPTIONAL_DEFAULT_RANK_COUNT = 0;

    private Map<LottoRank, Integer> result = new HashMap<>();
    private int money;

    public LottoResult(int money) {
        this.money = money;
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, DEFAULT_RESULT_COUNT);
        }
    }

    public void update(int count) {
        Optional<LottoRank> lottoRankOptional = LottoRank.getRank(count);
        lottoRankOptional.ifPresent(lottoRank -> {
            int rankCount = rankCount(lottoRank);
            result.put(lottoRank, rankCount + 1);
        });
    }

    public int rankCount(LottoRank lottoRank) {
        return Optional.ofNullable(result.get(lottoRank))
                .orElse(OPTIONAL_DEFAULT_RANK_COUNT);
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
