package me.namuhuchutong.lotto;


import java.util.Map;

public class LottoResult {

    private final Map<LottoCount, Lotto> lottoResult;

    public LottoResult(Map<LottoCount, Lotto> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public long getWinnings() {
        long totalPrice = 0;
        for (LottoCount count : lottoResult.keySet()) {
            totalPrice += LottoWinnings.valueOfCount(count);
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return lottoResult.toString();
    }
}
