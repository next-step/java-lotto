package lotto.domain.fixture;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

public class TestLottoFactory {

    public static Lotto create(int[] ints) {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(ints[0]),
                LottoNumber.of(ints[1]),
                LottoNumber.of(ints[2]),
                LottoNumber.of(ints[3]),
                LottoNumber.of(ints[4]),
                LottoNumber.of(ints[5]));

        return new Lotto(lottoNumbers);
    }
}
