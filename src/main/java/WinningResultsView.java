import java.util.stream.Collectors;

public class WinningResultsView {
    public static void printWinningResults(WinningResults winningResults) {
        System.out.println(generateWinningStatistics(winningResults));
    }

    private static String generateWinningStatistics(WinningResults winningResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계\n---------\n")
                .append(winningResults.winningRanks().stream()
                        .map(rank -> formatRank(rank, winningResults))
                        .collect(Collectors.joining("\n")));

        double winningRate = winningResults.winningRate();

        stringBuilder.append("\n")
                .append(String.format("총 수익률은 %.2f입니다.", winningRate));

        if (winningRate < 1) {
            stringBuilder.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

        return stringBuilder.toString();
    }

    private static String formatRank(Rank rank, WinningResults winningResults) {
        return String.format("%d개 일치 (%d원)- %d개", rank.getCountOfMatch(), rank.getWinningMoney(), winningResults.countByRank(rank));
    }
}
