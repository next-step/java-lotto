package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    void matchTest() {
        LottoNumber lottoNumber = new LottoNumber(5);

        assertThat(lottoNumber.hasMatchedNumber(Arrays.asList(1, 2, 3, 4, 5))).isTrue();
        assertThat(lottoNumber.hasMatchedNumber(Arrays.asList(1, 2, 3, 4, 6))).isFalse();
    }
}
