package lotto.domain;

public class AutoLotto extends Lotto {

    public AutoLotto() {
        super(convertToSet(LottoNumber.pickRandomLottoNumbers(LOTTO_NUMBER_COUNT)));
    }

    @Override
    public LottoType getLottoType() {
        return LottoType.AUTO;
    }
}
