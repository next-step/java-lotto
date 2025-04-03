package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 당첨 결과를 저장
 */
public class LottoEarning {
    private final int profit;
    private final double returnRate;
    private final Map<Rank, Integer> result;

    private LottoEarning(int profit, double returnRate, Map<Rank, Integer> result) {
        this.profit = profit;
        this.returnRate = returnRate;
        this.result = result;
    }

    public static LottoEarning from(WinningLottoNumbers winningLottoNumbers, List<List<Integer>> purchaseLotto, int purchasePrice) {
        Map<Rank, Integer> result = calculateResult(winningLottoNumbers, purchaseLotto);
        int profit = calculateTotalEarning(result);
        double returnRate = calculateReturnRate(profit, purchasePrice);
        return new LottoEarning(profit, returnRate, result);
    }

    private static Map<Rank, Integer> calculateResult(WinningLottoNumbers winningLottoNumbers, List<List<Integer>> lottos) {
        Map<Rank, Integer> result = new HashMap<>();
        for (List<Integer> lotto : lottos) {
            int matchCount = calculateMatchCount(winningLottoNumbers.getWinningLotto(), lotto);
            boolean bonusMatch = lotto.contains(winningLottoNumbers.getBonusNumber().getNumber());
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private static int calculateTotalEarning(Map<Rank, Integer> result) {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private static int calculateMatchCount(LottoTicket winningLotto, List<Integer> lottos) {
        return (int) lottos.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private static double calculateReturnRate(int profit, int purchasePrice) {
        if (purchasePrice == 0) {
            return 0.0;
        }
        return (double) profit / purchasePrice;
    }

    public int getProfit() {
        return profit;
    }

    public double getReturnRate() {
        return returnRate;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
