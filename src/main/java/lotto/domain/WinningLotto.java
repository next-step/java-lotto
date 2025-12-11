package lotto.domain;


import lotto.util.LottoNumberParser;

public class WinningLotto {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        this(LottoNumberParser.parse(winningNumbers), new LottoNumber(bonusNumber));
    }

    public WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format("당첨 숫자와 보너스 숫자가 일치합니다. (%d)", bonusNumber));
        }

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank getMatchedRank(LottoNumbers numbers) {
        int matchCount = winningNumbers.getMatchCount(numbers);
        return LottoRank.of(matchCount, numbers.contains(bonusNumber));
    }
}
