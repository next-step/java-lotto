package lotto.model;

public class NumberMatcher {
    private LottoNumbers winningNumbers;

    public NumberMatcher(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int howManyMatched(LottoNumbers userNumbers) {
        return winningNumbers.howManyMatched(userNumbers);
    }
}
