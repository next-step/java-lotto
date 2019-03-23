import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private final int TOTAL_PRICE;
    private final List<Lotto> lotto;
    private final WinningLotto winningLotto;

    public LottoResult(List<Lotto> lotto, WinningLotto winningLotto) {
        this.TOTAL_PRICE = lotto.size() * LottoMachine.LOTTO_PRICE;
        this.lotto = lotto;
        this.winningLotto = winningLotto;
    }

    public int getMatchNumber(Rank rank) {
        return (int) lotto.stream()
                .filter(lotto -> lotto.getRank(winningLotto) == rank)
                .count();
    }

    public double getProfit() {
        double sum = Arrays.stream(Rank.values())
                .mapToDouble(rank -> (getMatchNumber(rank) * rank.getWinningMoney()))
                .sum();
        return Math.floor(sum / TOTAL_PRICE * 100) / 100.0;
    }
}
