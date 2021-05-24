package lotto.domain;

public class WinningLottoNumbers {
    private Lotto winningLottoNumbers;
    private int bonusNumber;

    public WinningLottoNumbers(String winningNumbers, int bonusNumber) {
        Lotto winningLottoNumbers = new Lotto(winningNumbers);
        this.winningLottoNumbers = winningLottoNumbers;

        if (winningLottoNumbers.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 당첨 번호와 보너스 볼은 중복되서는 안됩니다.");
        }

        Lotto.throwIllegalArgumentException_lottoRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
