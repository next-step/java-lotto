package lotto.domain.number;

import java.util.List;

public class LottoWinningNumber {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);

        this.winningNumbers = LottoNumberGenerator.findAllByNumbers(winningNumbers);
        this.bonusNumber = LottoNumberGenerator.findByNumber(bonusNumber);
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
        }
    }
}
