package lotto.domain;

import java.util.List;

public class LottoMachine {
    private int purchaseLottoCount;
    private LottoNumber lottoNumber;
    private int purchaseAmount;

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

    public double calculateProfitRate(WinningStatistics winningStatistics) {

        int [] matchesRecords = winningStatistics.getMatchesRecord();

        double totalAmount = (matchesRecords[0] * 5000 + matchesRecords[1] * 50000 + matchesRecords[2] * 1500000 +matchesRecords[3] * 2000000000);

        double profitRate = totalAmount / purchaseAmount;
        return Double.parseDouble(String.format("%.2f", profitRate));
    }
}
