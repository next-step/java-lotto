package lotto.domain;

public class WinningLottoNumbers {

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLottoNumbers(final LottoNumbers lottoNumbers, final LottoNumber bonusLottoNumber) {
        validateOrThrow(lottoNumbers, bonusLottoNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public int countOfMatch(final Lotto lotto) {
        return this.lottoNumbers.countOfMatch(lotto.getNumbers());
    }

    public boolean matchBonus(final Lotto lotto) {
        return lotto.has(this.bonusLottoNumber);
    }

    private void validateOrThrow(final LottoNumbers lottoNumbers, final LottoNumber bonusLottoNumber) {
        if (lottoNumbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("로또 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }
}
