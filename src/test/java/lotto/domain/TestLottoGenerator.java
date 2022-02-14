package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class TestLottoGenerator implements LottoGenerator {

    @Override
    public List<LottoNumber> getLottoGeneratorNumbers() {
        return Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }
}
