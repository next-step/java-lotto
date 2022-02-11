package lotto.domain;

import java.util.Set;
import lotto.utils.Parser;

public class CorrectNumbers {

    private static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "로또 번호와 보너스 번호는 중복될 수 없습니다.";

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public CorrectNumbers(final String inputWinningNumbers, final String inputBonusNumber) {
        Lotto lotto = new Lotto(inputWinningNumbers);
        LottoNumber bonusNumber = new LottoNumber(Parser.parseInt(inputBonusNumber));
        validateDuplicateNumber(lotto, bonusNumber);

        this.winningNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(final Lotto winningNumbers, final LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers.get();
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
