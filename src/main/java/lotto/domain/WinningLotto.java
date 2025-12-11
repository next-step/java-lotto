package lotto.domain;


public class WinningLotto {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank getMatchedRank(LottoNumbers numbers) {
        int matchCount = winningNumbers.getMatchCount(numbers);
        return LottoRank.of(matchCount, numbers.contains(bonusNumber));
    }
}
