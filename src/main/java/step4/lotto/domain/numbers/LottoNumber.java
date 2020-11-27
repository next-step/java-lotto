package step4.lotto.domain.numbers;

import step4.lotto.util.CommonLottoCheck;

import java.util.List;

public class LottoNumber {

    private final List<Integer> lottoNumber;

    LottoNumber(final List<Integer> lottoNumber) {
        CommonLottoCheck.CheckNumber(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
