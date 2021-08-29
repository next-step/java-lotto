package lotto.domain;

import lotto.LottoConfig;

import java.util.Arrays;

public class LottoResults {
    private LottoResult lottoResult;
    private double lottoYield;

    public LottoResults(PurchaseLottoList purchaseLottoList, Lotto winningNumber) {
        purchaseLottoList.getPurchaseLottoList()
                .stream()
                .mapToInt(lotto -> lotto.sameLottoNumberCount(winningNumber))
                .boxed()
                .forEach(sameNumberCount ->
                        Arrays.stream(lottoResult.values())
                                .forEach(result -> result.addCount(sameNumberCount)));
        setLottoYield(purchaseLottoList);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public double getLottoYield() {
        return lottoYield;
    }

    private void setLottoYield(PurchaseLottoList purchaseLottoList) {
        double totalWinnings = Arrays.stream(lottoResult.values())
                .mapToInt(result -> result.getWinnings() * result.getCount())
                .sum();
        double totalPurchasePrice = purchaseLottoList.getPurchaseLottoList().size() * LottoConfig.LOTTO_PRICE;
        lottoYield = Math.round(totalWinnings / totalPurchasePrice * 100) / 100.0;
    }
}
