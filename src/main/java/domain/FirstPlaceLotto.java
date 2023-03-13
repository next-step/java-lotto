package domain;

public class FirstPlaceLotto extends Lotto {
    private LottoNumber bonusLottoNumber;

    public FirstPlaceLotto(String input, String bonusLottoNumber) {
        super(input);
        validate(input, bonusLottoNumber);
        this.bonusLottoNumber = new LottoNumber(bonusLottoNumber);
    }

    private void validate(String input, String bonusLottoNumber) {
        if (LottoUtil.stringSplitToList(input).contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또번호에 존재하지 않는 값이여야 합니다.");
        }
    }

    public LottoNumber getBonusLottoNumber() {
        return this.bonusLottoNumber;
    }
}
