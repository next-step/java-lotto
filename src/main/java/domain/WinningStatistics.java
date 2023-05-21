package domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class WinningStatistics {

    public static final int THRESHOLD = -1;

    private final WinningNumbers winningNumbers;

    private final BonusNumber bonusNumber;

    private Map<WinningPrizes, Integer> winningPrizeCount;

    public WinningStatistics(Set<Integer> winningNumbers,
                             int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
        this.winningPrizeCount = new EnumMap<WinningPrizes, Integer>(WinningPrizes.class);
    }

    public static WinningStatistics of(Set<Integer> winningNumbers, int bonusNumber) {
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers, bonusNumber);
        winningStatistics.setUpCount();
        return winningStatistics;
    }

    private void setUpCount() {
        for (WinningPrizes value : WinningPrizes.values()) {
            winningPrizeCount.put(value, 0);
        }
    }

    public Map<WinningPrizes, Integer> getWinningResults() {
        return winningPrizeCount;
    }

    public void matchCount(LottoResult lottoResult) {
        int count = lottoResult.calculateCount(winningNumbers);
        boolean bonusMatch = lottoResult.isBonusMatch(bonusNumber);
        decideRank(count, bonusMatch);
    }

    private void decideRank(int count, boolean bonusMatch) {
        WinningPrizes matchers = WinningPrizes.valueOf(count, bonusMatch);
        winningPrizeCount.put(matchers, winningPrizeCount.get(matchers) + 1);
    }

    public int getTotalWinnings() {
        return winningPrizeCount.entrySet()
                                .stream()
                                .mapToInt(entry
                                              -> entry.getKey()
                                                      .calculatePrizeMoney(entry.getValue()))
                                .sum();
    }
}
