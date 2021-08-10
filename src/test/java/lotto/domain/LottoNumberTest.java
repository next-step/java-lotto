package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create(int number) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validate(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(IllegalArgumentException.class);

    }
}