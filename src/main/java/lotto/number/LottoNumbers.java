package lotto.number;

import java.util.List;

public final class LottoNumbers extends AbstractLottoNumbers {

    protected LottoNumbers(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static LottoNumbers from(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

}
