package lotto.domain;

import java.util.List;

public class LottoMachine {
    private int purchaseLottoCount;
    private int purchaseAmount;
    private LottoNumber lottoNumber;

    static int PRICE_OF_LOTTO = 1000;

    public LottoMachine(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        purchaseLottoCount = purchaseAmount / PRICE_OF_LOTTO;
    }

    public int getPurchaseLottoCount() {
        return purchaseLottoCount;
    }

    public LottoNumber generateLottoNumber(List<Integer> asList) {
        lottoNumber = new LottoNumber(asList);

        return lottoNumber;
    }

    public LottoNumber generateLottoNumber() {
        return new LottoNumber();
    }

    public double calculateProfitRate(int[] matchingRecords) {

        double totalAmount = (matchingRecords[0] * 5000 + matchingRecords[1] * 50000 + matchingRecords[2] * 1500000 + matchingRecords[3] * 2000000000);

        double profitRate = totalAmount / purchaseAmount;

        return profitRate;
    }
}
