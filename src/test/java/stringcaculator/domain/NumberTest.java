package stringcaculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "9999"})
    void 숫자_테스트 (String number) {
        int parseNumber = Integer.parseInt(number);
        assertThat(new Number(number).value()).isEqualTo(parseNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"문자테스트", "-1"})
    void 숫자_예외_테스트 (String number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Number(number));
    }
}
