import java.util.List;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public Rank getRank(WinningLotto winningLotto) {
        return Rank.valueOf(winningLotto.getMatchNumber(lotto), winningLotto.isMatchBonusNumber(lotto));
    }

    public int getMatchNumber(List<Integer> lotto) {
        return (int) this.lotto.stream()
                .filter(number -> lotto.contains(number))
                .count();
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
