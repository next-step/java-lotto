package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoTest {
    @Test
    void checkValidLottoNumbersTest() {
        // 1, 2, 3, 5, 6
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1),
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(5), new LottoNumber(6));

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(lottoNumbers));
    }
}
