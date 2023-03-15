package lotto.domain;

public class WinLottoNumber {

    private static LottoNumbers beforeLottoNumber;
    private static int bonusNumber;

    public WinLottoNumber(LottoNumbers lottoNumber, int bonusNumber) {
        this.beforeLottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers getBeforeLottoNumber() {
        return beforeLottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
