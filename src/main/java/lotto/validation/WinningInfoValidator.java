package lotto.validation;

import lotto.exception.InvalidLottoException;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class WinningInfoValidator {
    public static void assertDuplicatedBonus(Lotto winningLottoNumber, LottoNumber bonusNumber) {
        if (winningLottoNumber.contains(bonusNumber)) {
            throw new InvalidLottoException("당첨 번호와 중복되지 않는 번호를 입력하세요");
        }
    }
}
