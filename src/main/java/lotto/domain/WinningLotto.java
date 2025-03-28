package lotto.domain;

import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Lotto numbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto numbers, LottoNumber bonusNumber) {
        validateInputs(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(List<LottoNumber> numbers, int bonusNumber) {
        this(Lotto.of(numbers), new LottoNumber(bonusNumber));
    }

    public Rank checkLottoRank(Lotto lotto) {
        Set<LottoNumber> winningNumbers = numbers.getLottoNumbers();
        Set<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        int matchCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonusBallMatch = lottoNumbers.stream()
                .anyMatch(bonusNumber::equals);

        return Rank.of(matchCount, bonusBallMatch);
    }

    private void validateInputs(Lotto numbers, LottoNumber bonusNumber) {
        Set<LottoNumber> winningNumbers = numbers.getLottoNumbers();

        if (isBonusNumberDuplicated(bonusNumber, winningNumbers)) {
            throw new IllegalArgumentException("입력된 보너스 번호가 이미 당첨번호에 포함되어 있습니다.");
        }
    }

    private boolean isBonusNumberDuplicated(LottoNumber bonusNumber, Set<LottoNumber> winningNumbers) {
        return winningNumbers.stream()
                .anyMatch(winningNumber -> winningNumber.equals(bonusNumber));
    }
}
