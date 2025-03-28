package lotto.domain;

import java.util.EnumMap;
import java.util.List;
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

    public static LottoResult of(Customer customer, Lotto winningLotto) {
        int purchaseAmount = customer.getPurchaseAmount();
        Map<Rank, Integer> lottoResult = analyzeLottoStatistics(customer.getLottoList(), winningLotto);

        return new LottoResult(purchaseAmount, lottoResult);
    }

    public static LottoResult of(Customer customer, WinningLotto winningLotto) {
        int purchaseAmount = customer.getPurchaseAmount();
        Map<Rank, Integer> lottoResult = analyzeLottoStatistics(customer.getLottoList(), winningLotto);

        return new LottoResult(purchaseAmount, lottoResult);
    }

    public static Map<Rank, Integer> analyzeLottoStatistics(List<Lotto> lottoList, Lotto winningLotto) {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        initializeStatistics(statistics);

        for (Lotto lotto : lottoList) {
            Rank rank = lotto.checkLottoRank(winningLotto.getLottoNumbers());
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    public static Map<Rank, Integer> analyzeLottoStatistics(List<Lotto> lottoList, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        initializeStatistics(statistics);

        for (Lotto lotto : lottoList) {
            Rank rank = winningLotto.checkLottoRank(lotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    private static void initializeStatistics(Map<Rank, Integer> statistics) {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getLottoStatistics() {
        return lottoStatistics;
    }

    public double getROI() {
        return (double) totalPrize / purchaseAmount;
    }

}
