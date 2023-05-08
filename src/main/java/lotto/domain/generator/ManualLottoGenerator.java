package lotto.domain.generator;

import lotto.domain.number.LottoNumber;

import java.util.HashSet;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator{

    @Override
    public HashSet<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        );
        return new HashSet<>(lottoNumbers);
    }
}
