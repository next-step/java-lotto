package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 67, 46})
    void 로또_번호_범위_체크(int lottoNumberInt) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(lottoNumberInt))
                .withMessageContaining("lotto numbers are between 1 and 45.");
    }
}
