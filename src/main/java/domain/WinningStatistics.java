package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final Map<WinningPrizes, Integer> winningStatistics = new LinkedHashMap<>();

    static {
        for (WinningPrizes value : WinningPrizes.values()) {
            winningStatistics.put(value, 0);
        }
    }

    private WinningNumbers winningNumbers;

    private BonusNumber bonusNumber;

    public WinningStatistics(List<Integer> winningNumbers,
                             int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public Map<WinningPrizes, Integer> getWinningResults2() {
        return winningStatistics;
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
        WinningPrizes prize = WinningPrizes.valueOf(count, bonusMatch);
        winningStatistics.put(prize, winningStatistics.get(prize) + 1);
    }

    public int getTotalWinnings() {
        int winnings = 0;
        for (WinningPrizes prize : winningStatistics.keySet()) {
            winnings += prize.calculatePrizeMoney(winningStatistics.get(prize));
        }
        return winnings;
    }
}
