import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Rank getRank(Lotto winningLotto, int bonusNumber) {
        return Rank.valueOf(getMatchNumber(winningLotto), isMatchBonusNumber(bonusNumber));
    }

    private int getMatchNumber(Lotto winningLotto) {
        return (int) winningLotto.lottoNumbers.stream()
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
