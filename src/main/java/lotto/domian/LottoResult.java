package lotto.domian;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> result;

    private void initializeResult() {
        result = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
    }

    private LottoResult() {
        initializeResult();
    }

    public static LottoResult initializeLottoResult(){
        return new LottoResult();
    }

    public void updateResultForRank(LottoRank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public float calculateTotalProfitRate(int money) {
        long totalWinningAmount = result.entrySet().stream()
                .mapToLong(rank -> rank.getKey().getPrizeMoney() * rank.getValue())
                .sum();

        // 변경된 수익률 계산 로직
        float profitRate = ((float)totalWinningAmount - money) / money * 100;

        return profitRate;
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public int getResultCount(LottoRank rank){
        return result.get(rank).intValue();
    }
}
