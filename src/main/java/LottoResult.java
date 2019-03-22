import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private final int TOTAL_PRICE;
    private final List<Lotto> lottos;
    private final Lotto winningLoto;
    private final int bonusNumber;

    public LottoResult(List<Lotto> lottos, Lotto winningLoto, int bonusNumber) {
        this.TOTAL_PRICE = lottos.size() * LottoMachine.LOTTO_PRICE;
        this.lottos = lottos;
        this.winningLoto = winningLoto;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchNumber(Rank rank) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.getRank(winningLoto, bonusNumber) == rank)
                .count();
    }

    public double getProfit() {
        double sum = Arrays.stream(Rank.values())
                .mapToDouble(rank -> (getMatchNumber(rank) * rank.getWinningMoney()))
                .sum();
        return Math.floor(sum / TOTAL_PRICE * 100) / 100.0;
    }
}
