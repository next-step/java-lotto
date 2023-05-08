package lotto.step4.domain;

import java.util.Collections;
import java.util.Set;

public class ValidateNumbers {
    public Set<Integer> validateNumbers(Set<Integer> lottoNumber) {
        if (size(lottoNumber)) {
            throw new IllegalArgumentException("당첨 번호는 6개만 가능합니다.");
        }
        if (isInRange(lottoNumber)) {
            throw new IllegalArgumentException("당첨 번호는 1 ~ 45까지만 가능합니다.");
        }
        return lottoNumber;
    }

    private boolean size(Set<Integer> lottoNumber) {
        return lottoNumber.size() != 6;
    }

    private boolean isInRange(Set<Integer> lottoNumber) {
        return Collections.max(lottoNumber) > 45 || Collections.min(lottoNumber) < 1;
    }

    public int validateBonusNumber(int bonusNumber, Set<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다. (입력된 보너스 값: " + bonusNumber + ")");
        }
        if (bonusNumber > 45 || bonusNumber < 0) {
            throw new IllegalArgumentException("보너스 볼 입력 범위는 1~45 입니다. (입력된 보너스 값: " + bonusNumber + ")");
        }
        return bonusNumber;
    }
}
