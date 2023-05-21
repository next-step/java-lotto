package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private WinningNumbers winningNumbers;

    private BonusNumber bonusNumber;

    private Map<WinningPrizeMatchers, Integer> winningPrizeCount;

    public WinningStatistics(List<Integer> winningNumbers,
                             int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
        this.winningPrizeCount = new LinkedHashMap<>();
    }

    public static WinningStatistics of(List<Integer> winningNumbers,
                                int bonusNumber) {
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers, bonusNumber);
        winningStatistics.setUpCount();
        return winningStatistics;
    }

    private void setUpCount() {
        for (WinningPrizeMatchers value : WinningPrizeMatchers.values()) {
            winningPrizeCount.put(value, 0);
        }
    }

    public Map<WinningPrizeMatchers, Integer> getWinningResults() {
        return winningPrizeCount;
    }

    public void matchCount(LottoNumber[] lottoNumbers) {
        int count = 0;
        boolean bonusMatch = false;
        for (LottoNumber num : lottoNumbers) {
            count = num.addCountIfContain(count, winningNumbers);
            bonusMatch = bonusNumber.isBonusMatch(num);
        }
        decideRank(count, bonusMatch);
    }

    private void decideRank(int count, boolean bonusMatch) {
        WinningPrizeMatchers matchers = WinningPrizeMatchers.valueOf(count, bonusMatch);
        winningPrizeCount.put(matchers, winningPrizeCount.get(matchers) + 1);
    }

    public int getTotalWinnings() {
        int winnings = 0;
        for (WinningPrizeMatchers matchers : winningPrizeCount.keySet()) {
            winnings += matchers.calculateWinningPrize()
                                .calculatePrizeMoney(winningPrizeCount.get(matchers));
        }
        return winnings;
    }
}
