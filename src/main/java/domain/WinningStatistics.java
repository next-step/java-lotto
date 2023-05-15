package domain;

import java.util.List;

public class WinningStatistics {

    public static final List<WinningPrizes> WINNING_PRIZES = List.of(WinningPrizes.FOURTH_PRIZE, WinningPrizes.THIRD_PRIZE, WinningPrizes.SECOND_PRIZE, WinningPrizes.FIRST_PRIZE);

    public static final int OFFSET = 3;
    private int[] winningStatistics = new int[4];

    private List<Integer> winningNumbers;

    public WinningStatistics(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int[] getWinningResults() {
        return winningStatistics;
    }

    public void matchCount(LottoNumber[] lottoNumbers) {
        int count = 0;
        for (LottoNumber num : lottoNumbers) {
            count = num.addCountIfContain(count, winningNumbers);
        }
        if (count >= OFFSET) {
            winningStatistics[count - OFFSET]++;
        }
    }

    public int getTotalWinnings() {
        int winnings = 0;
        for (int i = 0; i < winningStatistics.length; i++) {
            winnings += WINNING_PRIZES.get(i).calculatePrizeMoney(winningStatistics[i]);
        }
        return winnings;
    }
}
