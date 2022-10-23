package lotto.domain;

import java.util.Objects;

public class WinningNumbers extends Lotto {
    private static final String DUPLICATED_BONUS_NUMBER_MESSAGE = "보너스 번호는 먼저 뽑힌 로또번호와 중볼될 수 없습니다.";

    private final LottoNumber bonus;

    public WinningNumbers(String numbers, String bonus) {
        super(numbers);
        this.bonus = validateBonusNumber(bonus);
    }

    boolean hasBonus(Lotto lotto) {
        return lotto.toIntSet().contains(bonus.getNumber());
    }

    private LottoNumber validateBonusNumber(String bonus) {
        LottoNumber bonusNumber = new LottoNumber(bonus);
        if (isDuplicated(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_MESSAGE);
        }
        return bonusNumber;
    }

    private boolean isDuplicated(LottoNumber bonus) {
        return this.toIntSet().contains(bonus.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonus);
    }
}
