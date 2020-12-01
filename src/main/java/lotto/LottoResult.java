package lotto;

import java.util.HashMap;

public class LottoResult {

    private final int cost;
    private final HashMap<LottoPlace, Integer> placeCountMap = new HashMap<>();

    public LottoResult(int cost) {
        this.cost = cost;
    }

    public void addPlace(LottoPlace place) {
        placeCountMap.compute(place, (k, count) -> count == null || count == 0 ? 1 : count + 1);
    }

    public int getWinningPrize() {
        return placeCountMap.entrySet().stream()
                .map(entry -> entry.getKey().getPrize() * entry.getValue())
                .reduce((a, b) -> a + b)
                .orElse(0);
    }

    public double getProfitRatio() {
        return (double)getWinningPrize() / cost;
    }

    public int getWinnerPlaceCount(LottoPlace place) {
        Integer count = placeCountMap.get(place);
        return count == null ? 0 : count;
    }

}
