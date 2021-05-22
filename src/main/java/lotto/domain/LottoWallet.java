package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoWallet {
    private Map<LottoResult, Integer> lottoResultCounts;
    private final Money money;

    public LottoWallet(Money money) {
        initLottoResultCounts();
        this.money = money;
    }

    private void initLottoResultCounts() {
        this.lottoResultCounts = new HashMap<>();
        for (int i = 0; i < LottoResult.values().length; i++) {
            lottoResultCounts.put(LottoResult.values()[i], 0);
        }
    }

    public void addLottoResult(LottoResult lottoResult) {
        lottoResultCounts.computeIfPresent(lottoResult, (lottoResultKey, count) -> ++count);
    }

    public double getProfitRate() {
        return (double) getTotalReward() / money.getMoney();
    }

    private int getTotalReward() {
        return lottoResultCounts.keySet()
                .stream()
                .mapToInt(this::getReward)
                .sum();
    }

    private int getReward(LottoResult lottoResult) {
        return lottoResultCounts.get(lottoResult) * lottoResult.getReward();
    }

    public Map<LottoResult, Integer> getLottoResultCounts() {
        return lottoResultCounts;
    }
}
