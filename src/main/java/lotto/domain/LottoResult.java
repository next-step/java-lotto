package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final int purchaseAmount;
    private final Map<Rank, Integer> lottoStatistics;
    private final int totalPrize;

    public LottoResult(int purchaseAmount, Map<Rank, Integer> lottoStatistics) {
        this.purchaseAmount = purchaseAmount;
        this.lottoStatistics = lottoStatistics;
        this.totalPrize = calculateTotalPrize(lottoStatistics);
    }

    private int calculateTotalPrize(Map<Rank, Integer> lottoResult) {
        return lottoResult.entrySet().stream()
                .mapToInt((rank) -> rank.getKey().getPrize() * rank.getValue())
                .sum();
    }

    public static LottoResult of(Customer customer, WinningLotto winningLotto) {
        int purchaseAmount = customer.getPurchaseAmount();
        Map<Rank, Integer> lottoResult = customer.determineLottosResult(winningLotto);

        return new LottoResult(purchaseAmount, lottoResult);
    }

    public Map<Rank, Integer> getLottoStatistics() {
        return lottoStatistics;
    }

    public double getROI() {
        return (double) totalPrize / purchaseAmount;
    }

}
