package lotto.utils;

import lotto.domain.lotto.LottoNumber;

import java.util.Arrays;
import java.util.List;

public class TestLottoGenerator implements LottoGenerator {

    public List<LottoNumber> generate() {
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );
        return numbers;
    }
}
