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

    public long calculateTotalWinningAmount() {
        return result.entrySet().stream()
                .mapToLong(rank -> rank.getKey().getPrizeMoney() * rank.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public int getResultCount(LottoRank rank){
        return result.get(rank).intValue();
    }
}
