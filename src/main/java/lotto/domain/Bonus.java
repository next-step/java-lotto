package lotto.domain;

public class Bonus {

    private final LottoNumber bonusNumber;

    public Bonus(int bonusNumber, Lotto winningLotto) {
        validateDuplicate(bonusNumber, winningLotto);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicate(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.getLotto().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 중복되는 보너스 번호는 사용할 수 없습니다.");
        }
    }
}
