package lotto.domain.lotto;

public class WinningLotto {
    private final Lotto numbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto numbers, LottoNumber bonusNumber) {
        assertNumbersNotDuplicated(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void assertNumbersNotDuplicated(Lotto numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Lotto numbers() {
        return this.numbers;
    }

    public LottoNumber bonusNumber() {
        return this.bonusNumber;
    }
}
