package LottoTest;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoRule;

import java.util.Arrays;

public class FixedLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public LottoNumber numbers() {
        return new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoRule());
    }

}
