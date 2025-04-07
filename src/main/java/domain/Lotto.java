package domain;


import java.util.List;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.numbers = new LottoNumbers(lottoNumbers);
    }

    public int matchCount(WinningNumber winningNumber) {
        return numbers.matchCount(winningNumber);
    }

    public boolean matchBonusNumber(WinningNumber winningNumber) {
        return numbers.matchBonusNumber(winningNumber);
    }

    public List<Integer> getLottoNumbers() {
        return numbers.getLottoNumbers();
    }
}
