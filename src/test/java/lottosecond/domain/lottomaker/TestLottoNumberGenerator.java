package lottosecond.domain.lottomaker;

import lottosecond.domain.lottomaker.LottoNumberGenerator;
import lottosecond.domain.lotto.LottoNumber;

import java.util.List;

public class TestLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<LottoNumber> makeLottoNumberList() {
        return List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }
}
