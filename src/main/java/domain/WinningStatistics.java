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

    public void matchCount(int[] lottoResult) {
        int count = 0;
        for (int num : lottoResult) {
            count = addCountIfContains(count, num);
        }
        if (count >= OFFSET) {
            winningStatistics[count - OFFSET]++;
        }
    }

    private int addCountIfContains(int count, int num) {
        if (winningNumbers.contains(num)) {count++;}
        return count;
    }

    public int getTotalWinnings() {
        int winnings = 0;
        for (int i = 0; i < winningStatistics.length; i++) {
            winnings += WINNING_PRIZES.get(i).calculatePrizeMoney(winningStatistics[i]);
        }
        return winnings;
    }
}
