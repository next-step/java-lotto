package lottogame.model;

public class WinningLottoNumbers {

    private Lotto winningLottoNumbers;
    private LottoNumber bonusNumber;

    public WinningLottoNumbers(Lotto winningLotto, LottoNumber bonusNumber) {

        if (winningLottoNumbers.winningLottoNumbersContainsBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("로또 당첨 번호와 보너스 볼은 중복되서는 안됩니다.");
        }

        this.winningLottoNumbers = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}
