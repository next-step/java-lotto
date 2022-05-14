package step2.domain;

import java.util.Objects;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(String input, String bonus) {
        this.winningNumbers = new Lotto(input);
        this.bonusNumber = initBonusNumber(bonus);
        validateBonusNumberDuplicate();
    }

    private LottoNumber initBonusNumber(String bonus) {
        validateNullAndEmpty(bonus);
        return LottoNumber.from(bonus);
    }

    private void validateNullAndEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 Null 이거나 공백으로 이루어져있습니다.");
        }
    }

    private void validateBonusNumberDuplicate() {
        if (this.winningNumbers.contain(this.bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호가 중복될 수 없습니다.");
        }
    }

    public LottoRank calculateRank(Lotto operand) {
        if (operand == null) {
            throw new IllegalArgumentException("등수를 계산할 로또가 널 입니다.");
        }
        long hitCount = winningNumbers.calculateHitCount(operand);
        boolean containBonusNumber = operand.contain(bonusNumber);
        return LottoRank.toRank(hitCount, containBonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
