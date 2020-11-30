package lotto;

public class WinningStatistic {

    private final int[] statistics = {0, 0, 0, 0};
    private final static int THREE_WINNING = 3;
    private final static int FOUR_WINNING = 4;
    private final static int FIVE_WINNING = 5;
    private final static int SIX_WINNING = 6;

    public WinningStatistic (WinningCounts winningCounts) {
        for (int i = 0; i < winningCounts.size(); i++) {
            WinningCount winningCount = winningCounts.getWinningCount(i);

            if (winningCount.getCount() == THREE_WINNING) {
                statistics[0]++;
            } else if (winningCount.getCount() == FOUR_WINNING) {
                statistics[1]++;
            } else if (winningCount.getCount() == FIVE_WINNING) {
                statistics[2]++;
            } else if (winningCount.getCount() == SIX_WINNING) {
                statistics[3]++;
            }
        }
    }

    public int getStatistics(int index) {
        return statistics[index];
    }
}
