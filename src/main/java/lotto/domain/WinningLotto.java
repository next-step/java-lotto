package lotto.domain;

public class WinningLotto {

    private final Lotto numbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto numbers, LottoNumber bonusNumber) {
        if (numbers.isMatchWith(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호에 포함되지 않는 번호여야 합니다.");
        }

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto numbers() {
        return numbers;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
