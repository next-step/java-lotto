package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {LottoNumber.MIN_VALUE - 1, LottoNumber.MAX_VALUE + 1})
    void LottoNumber는_범위에_맞지_않는_숫자로_생성하면_예외를_발생시킨다(int value) {
        assertThatThrownBy(() -> {
            new LottoNumber(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
