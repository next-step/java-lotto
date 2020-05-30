package step2;

import java.util.Arrays;

public enum WinningStatistics {
    WINING3(3, 5000, (count) -> System.out.println("3개 일치 (5000원)- " + count + "개")),
    WINING4(4, 50000, (count) -> System.out.println("4개 일치 (50000원)- " + count + "개")),
    WINING5(5, 1500000, (count) -> System.out.println("5개 일치 (1500000원)- " + count + "개")),
    WINING6(6, 2000000000, (count) -> System.out.println("6개 일치 (2000000000원)- " + count + "개"));

    private int matchedNumberCount;
    private int winningPrice;
    private StatisticsPrintInterface statisticsPrintInterface;

    WinningStatistics(int matchedNumberCount, int winningPrice, StatisticsPrintInterface statisticsPrintInterface) {
        this.matchedNumberCount = matchedNumberCount;
        this.winningPrice = winningPrice;
        this.statisticsPrintInterface = statisticsPrintInterface;
    }

    public static WinningStatistics valueOfWinningCount(int winningCount) {
        return Arrays.stream(values()).filter(statistics -> statistics.compare(statistics.matchedNumberCount, winningCount)).findAny().orElseThrow(IllegalArgumentException::new);
    }

    private boolean compare(int number1, int number2) {
        return number1 == number2;
    }

    public void print(int count) {
        statisticsPrintInterface.print(count);
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
