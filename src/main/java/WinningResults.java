import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResults {
    private static final int PRICE = 5000;

    private final List<WinningResult> winningResults;
    private final LottoNumber bonusNumber;

    public WinningResults(List<WinningResult> winningResultList) {
        this.winningResults = winningResultList;
        this.bonusNumber = null;
    }

    public WinningResults(List<WinningResult> winningResultList, LottoNumber bonusNumber) {
        this.winningResults = winningResultList;
        this.bonusNumber = bonusNumber;
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

    public List<Rank> winningRanks() {
        return Arrays.stream(Rank.values())
                .filter(i -> i.getCountOfMatch() >= Rank.FIFTH.getCountOfMatch())
                .collect(Collectors.toList());
    }

    public List<WinningResult> get() {
        return this.winningResults;
    }
}
