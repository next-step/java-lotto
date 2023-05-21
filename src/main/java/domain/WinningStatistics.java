package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningStatistics {

    private final WinningNumbers winningNumbers;

    private final BonusNumber bonusNumber;

    private Map<WinningPrizeMatcher, Integer> winningPrizeCount;

    public WinningStatistics(Set<Integer> winningNumbers,
                             int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
        this.winningPrizeCount = new EnumMap<WinningPrizeMatcher, Integer>(WinningPrizeMatcher.class);
    }

    public static WinningStatistics of(Set<Integer> winningNumbers, int bonusNumber) {
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers, bonusNumber);
        winningStatistics.setUpCount();
        return winningStatistics;
    }

    private void setUpCount() {
        for (WinningPrizeMatcher value : WinningPrizeMatcher.values()) {
            winningPrizeCount.put(value, 0);
        }
    }

    public Map<WinningPrizeMatcher, Integer> getWinningResults() {
        return winningPrizeCount;
    }

    public void matchCount(LottoResult lottoResult) {
        int count = lottoResult.calculateCount(winningNumbers);
        boolean bonusMatch = lottoResult.isBonusMatch(bonusNumber);
        decideRank(count, bonusMatch);
    }

    private void decideRank(int count, boolean bonusMatch) {
        WinningPrizeMatcher matchers = WinningPrizeMatcher.valueOf(count, bonusMatch);
        winningPrizeCount.put(matchers, winningPrizeCount.get(matchers) + 1);
    }

    public int getTotalWinnings() {

        return winningPrizeCount.entrySet()
                                .stream()
                                .mapToInt(entry
                                              -> entry.getKey()
                                                      .calculateWinningPrize()
                                                      .calculatePrizeMoney(entry.
                                                                               getValue()))
                                .sum();
    }
}
