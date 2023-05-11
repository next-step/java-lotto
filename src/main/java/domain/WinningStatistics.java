package domain;

import java.util.List;

public class WinningStatistics {

    private static final int FOURTH_PRIZE = 5000;

    private static final int THIRD_PRIZE = 50000;

    private static final int SECOND_PRIZE = 1500000;

    private static final int FIRST_PRIZE = 2000000000;

    public static final int[] WINNING_PRIZES = { FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE };

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
            winnings += winningStatistics[i] * WINNING_PRIZES[i];
        }
        return winnings;
    }
}
