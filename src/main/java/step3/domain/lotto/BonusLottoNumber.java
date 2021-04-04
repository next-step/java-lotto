package step3.domain.lotto;

public final class BonusLottoNumber {

    private LottoNumber bonusLottoNumber;

    private BonusLottoNumber(LottoNumber bonusLottoNumber) {
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static final BonusLottoNumber valueOf(int bonusNumber) {
        return valueOf(LottoNumber.valueOf(bonusNumber));
    }

    public static final BonusLottoNumber valueOf(LottoNumber bonusNumber) {
        return new BonusLottoNumber(bonusNumber);
    }

}
