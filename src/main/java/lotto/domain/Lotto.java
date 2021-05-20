package lotto.domain;

import java.util.Set;

public class Lotto {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final long PRICE = 1_000L;

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto auto() {
        return new Lotto(LottoNumbersGenerator.generate());
    }

    public Set<LottoNumber> getNumbers() {
        return lottoNumbers.getValue();
    }

    public WinningType match(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return WinningType.findType(countOfMatch(winningNumbers), isBonusMatch(winningNumbers, bonusNumber));
    }

    private int countOfMatch(LottoNumbers winningNumbers) {
        return lottoNumbers.matchNumbers(winningNumbers);
    }

    private boolean isBonusMatch(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return countOfMatch(winningNumbers) == 5 && iscontainsBonus(bonusNumber);
    }

    public boolean iscontainsBonus(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
