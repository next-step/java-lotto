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
        this(new ManualLotto(numbers), LottoNumber.of(bonusNumber));
    }

    public Rank determineLottoRank(Lotto lotto) {
        int matchCount = lotto.countNumberMatchCount(numbers.getLottoNumbers());
        boolean bonusNumberMatch = lotto.isNumberMatched(bonusNumber);

        return Rank.of(matchCount, bonusNumberMatch);
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
