package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void LottoNumberConstructorTest(Integer number) {
        assertThat(new LottoNumber(number).getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {0,46})
    void LottoNumberConstructorExceptionTest(Integer number) {
        assertThatThrownBy(() -> new LottoNumber((number))).isInstanceOf(
                IllegalArgumentException.class)
            .hasMessage("In LottoNumber entered not supported argument");
    }

}
