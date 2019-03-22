import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Rank getRank(WinningLotto winningLotto) {
        return Rank.valueOf(getMatchNumber(winningLotto.getLotto()), isMatchBonusNumber(winningLotto.getBonusNumber()));
    }

    private int getMatchNumber(List<Integer> winningLotto) {
        return (int) winningLotto.stream()
                .filter(number -> this.lottoNumbers.contains(number))
                .count();
    }

    private boolean isMatchBonusNumber(int bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
