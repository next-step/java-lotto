package lottogame.domain.lotto;

public class BonusLottoNumber extends LottoNumber {
    public BonusLottoNumber(int number, LottoNumbers lottoNumbers) {
        super(number);
        validate(this, lottoNumbers);
    }

    private void validate(BonusLottoNumber bonusLottoNumber, LottoNumbers lottoNumbers) {
        if (lottoNumbers.hasNumber(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 같을 수 없습니다.");
        }
    }
}
