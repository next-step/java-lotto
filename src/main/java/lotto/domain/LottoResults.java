package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoResults {
    private double lottoYield;
    private LottoResult lottoResult;

    public LottoResults(List<Integer> sameNumberCounts) {
        lottoResult = new LottoResult(sameNumberCounts);
        setLottoYield(sameNumberCounts.size());
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public double getLottoYield() {
        return lottoYield;
    }

    private void setLottoYield(int lottoCount) {
        double totalWinnings = Arrays.stream(LottoRank.values())
                .mapToInt(result -> result.getWinnings() * lottoResult.getValue(result.getSameNumberCount()))
                .sum();
        double totalPurchasePrice = lottoCount * Lotto.LOTTO_PRICE;
        lottoYield = Math.round(totalWinnings / totalPurchasePrice * 100) / 100.0;
    }

}
