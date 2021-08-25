package lotto;

public class WinningLottoNumbers {
    private final LottoNumbers prevWinningLottoNumbers;
    private final int bonusNumber;

    public WinningLottoNumbers(LottoNumbers prevWinningLottoNumbers, int bonusNumber) {
        if (prevWinningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("The bonus number must not be included in the winning number.");
        }

        this.prevWinningLottoNumbers = prevWinningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int match(LottoNumbers lottoNumbers) {
        return lottoNumbers.match(this.prevWinningLottoNumbers);
    }

}
