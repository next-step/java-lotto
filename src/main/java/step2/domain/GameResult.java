package step2.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final Map<LottoRank, Integer> result;

    public GameResult(List<LottoRank> lottoRanks) {
        this.result = new EnumMap<>(LottoRank.class);
        lottoRanks.forEach(this::putToResult);
    }

    private void putToResult(LottoRank lottoRank) {
        this.result.putIfAbsent(lottoRank, 0);
        this.result.computeIfPresent(lottoRank, (key, value) -> value + 1);
    }

    public ReturnRate calculateReturnRate(PurchaseMoney purchaseMoney) {
        int sumOfPrizeMoney = getSumOfPrizeMoney();
        return purchaseMoney.calculateReturnRate(sumOfPrizeMoney);
    }

    private int getSumOfPrizeMoney() {
        return result.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }
}
