import java.util.List;

public class WinningResults {
    private static final int PRICE = 5000;

    private final List<WinningResult> winningResults;

    public WinningResults(List<WinningResult> winningResultList) {
        this.winningResults = winningResultList;
    }

    public int countByRank(Rank rank) {
        return (int) winningResults.stream()
                .filter(winningResult -> winningResult.rank().equals(rank))
                .count();
    }

    public double winningRate() {
        Long winningMoney = winningResults.stream()
                .map(WinningResult::winningMoney)
                .reduce(Long::sum)
                .orElse(0L);

        return (double) winningMoney / (winningResults.size() * PRICE);
    }

    public List<WinningResult> get() {
        return this.winningResults;
    }
}
