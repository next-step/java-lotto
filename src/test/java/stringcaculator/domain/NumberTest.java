package stringcaculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class NumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "198", "98765434"})
    @DisplayName("Number의 객체 생성이 정상적으로 되고 값이 같으면 같은 객체인지 확인한다.")
    void legalParameter(String value) {
        assertThat(new Number(new StringToIntegerValue(value)).equals(new Number(new StringToIntegerValue(value)))).isTrue();
    }
}