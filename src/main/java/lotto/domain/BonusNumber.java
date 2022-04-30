package lotto.domain;

import java.util.List;

public class BonusNumber {

    private int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber withValidate(int bonusNumber, List<Integer> lottoNumbers) {
        validate(bonusNumber, lottoNumbers);

        return new BonusNumber(bonusNumber);
    }

    private static void validate(int bonusNumber, List<Integer> lottoNumbers) {
        if (lottoNumbers.stream()
            .anyMatch(integer -> integer == bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 동일한 보너스 넘버는 설정 할 수 없음.");
        }
    }

    public int get() {
        return this.bonusNumber;
    }

    public boolean isEqualTo(int bonusNumber) {
        return this.bonusNumber == bonusNumber;
    }
}
