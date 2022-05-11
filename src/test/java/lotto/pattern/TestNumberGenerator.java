package lotto.pattern;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

public class TestNumberGenerator implements NumberGenerator {
    @Override
    public int generator() {
        return 0;
    }

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        return Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }
}
