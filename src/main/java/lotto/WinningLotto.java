package lotto;

public class WinningLotto {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호와 겹치면 안됩니다.");
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult match(LottoNumbers numbers) {
        return LottoResult.of(getMatchCount(numbers), hasBonusNumber(numbers));
    }

    private boolean hasBonusNumber(LottoNumbers numbers) {
        return numbers.hasNumber(bonusNumber);
    }

    private int getMatchCount(LottoNumbers numbers) {
        return winningNumbers.getMatchCount(numbers);
    }
}
