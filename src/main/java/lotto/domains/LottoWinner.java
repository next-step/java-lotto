package lotto.domains;

public class LottoWinner {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public LottoWinner(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복될 수 없습니다.");
        }

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public boolean isBonus(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
