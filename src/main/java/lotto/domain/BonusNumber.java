package lotto.domain;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(List<Integer> lottoNumber, int bonusNumber) {
        if (checkDuplication(lottoNumber, bonusNumber)) {
            throw new BonusNumberDuplicateException();
        }
        this.bonusNumber = bonusNumber;
    }

    private boolean checkDuplication(List<Integer> lottoNumber, int bonusNumber) {
        return lottoNumber.stream()
                .filter(e -> e.intValue() == bonusNumber)
                .count() == 1;
    }

    public boolean equals(int number) {
        return bonusNumber == number;
    }
}
