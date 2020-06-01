package lotto.domain.lotto.generator;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.generator.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator<LottoNumber> {
    @Override
    public List<LottoNumber> getNumbers() {
        return Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }
}
