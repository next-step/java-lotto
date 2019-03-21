import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int getMatchNumber(Lotto winningLotto) {
        return (int) winningLotto.lottoNumbers.stream()
                .filter(number -> this.lottoNumbers.contains(number))
                .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
