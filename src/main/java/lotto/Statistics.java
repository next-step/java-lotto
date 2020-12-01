package lotto;

public class Statistics {

    private final int[] statisticsCount;

    public Statistics(int[] statisticsCount) {
        this.statisticsCount = statisticsCount;
    }

    public Statistics calculateStatistics(int winningCount) {
        if (winningCount == Message.THREE_WINNING) {
            statisticsCount[0]++;
        } else if (winningCount == Message.FOUR_WINNING) {
            statisticsCount[1]++;
        } else if (winningCount == Message.FIVE_WINNING) {
            statisticsCount[2]++;
        } else if (winningCount == Message.SIX_WINNING) {
            statisticsCount[3]++;
        }

        return new Statistics(statisticsCount);
    }

    public int getStatisticsCount(int index) {
        return statisticsCount[index];
    }
}
