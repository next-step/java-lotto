package lotto.common;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoStub {

    private LottoStub() {
    }

    public static LottoNumbers getLottoNumbersOneToSix() {
        return new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }

    public static LottoNumbers getLottoNumbers(int... number) {
        return new LottoNumbers(Arrays.stream(number)
                .mapToObj(LottoNumber::new).collect(Collectors.toList()));
    }

}
