package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ValueSource(ints = {56})
    @ParameterizedTest
    void 로또_번호는_1부터_45까지_확인(int ints) {
        LottoNumber lottoNum = new LottoNumber(46);
        assertThatExceptionOfType(IllegalAccessError.class)
                .isThrownBy(() -> new LottoNumber(ints));
    }

}